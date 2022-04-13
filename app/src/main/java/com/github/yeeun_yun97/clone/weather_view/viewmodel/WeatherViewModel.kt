package com.github.yeeun_yun97.clone.weather_view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.yeeun_yun97.clone.weather_view.WeatherApi
import com.github.yeeun_yun97.clone.weather_view.model.WeatherData
import com.github.yeeun_yun97.clone.weather_view.model.WeatherResponse
import com.github.yeeun_yun97.clone.weather_view.repository.WeatherRepository
import com.github.yeeun_yun97.clone.weather_view.secret.SecretKeys
import kotlinx.coroutines.*

class WeatherViewModel : ViewModel() {
    val weatherData = MutableLiveData<WeatherData>()


    private val repository = WeatherRepository()

    private var job: Job = Job()
    private val loading = MutableLiveData<Boolean>()

    private val errorMessage = MutableLiveData<String>()
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    init{
        this.loadWeatherData()
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    private fun loadWeatherData() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repository.loadWeatherData()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val body: WeatherResponse = response.body()!!
                    val status: String = when (response.body()!!.weather[0]["main"]!!) {
                        "sunny" -> "맑음"
                        else -> "흐림"
                    }
                    val data = WeatherData(status, body.main["temp"]!!.toDouble().toInt())
                    Log.i("debug coroutine response",data.toString())
                    weatherData.postValue(data)
                } else {
                    onError("Error: ${response.message()}")
                }
            }
        }
    }

}