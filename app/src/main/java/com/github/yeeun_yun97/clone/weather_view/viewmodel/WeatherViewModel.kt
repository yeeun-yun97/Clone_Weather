package com.github.yeeun_yun97.clone.weather_view.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yeeun_yun97.clone.weather_view.model.WeatherData
import com.github.yeeun_yun97.clone.weather_view.repository.WeatherRepository
import kotlinx.coroutines.*
import okio.Timeout

class WeatherViewModel : ViewModel() {
    val weatherData = MutableLiveData<WeatherData>()

    private val repository = WeatherRepository()
    private var job: Job = Job()
    private val loading = MutableLiveData<Boolean>()
    private val errorMessage = MutableLiveData<String>()

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    fun loadWeatherData() {
        job = viewModelScope.launch(Dispatchers.IO) {
            //5초 제한 걸고 코루틴 시작.
            try {
                withTimeout(5000) {
                    val response = repository.loadWeatherData()
                    if (response.isSuccessful) {
                        val body = response.body()!!
                        val status = body.weather[0]["main"]!!
                        val temperature = body.main["temp"]!!.toDouble().toInt()
                        val data = WeatherData(status, temperature)
                        Log.d("created Model from API", data.toString())
                        delay(2000)
                        weatherData.postValue(data)
                    } else {
                        onError("Error: ${response.message()}")
                    }
                }
            } catch (exception: TimeoutCancellationException) {
                onError("Error: Could not receive Api Response in 5 seconds")
            }
        }
    }

}