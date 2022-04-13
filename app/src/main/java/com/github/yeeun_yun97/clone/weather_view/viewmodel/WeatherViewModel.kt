package com.github.yeeun_yun97.clone.weather_view.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.yeeun_yun97.clone.weather_view.WeatherApi
import com.github.yeeun_yun97.clone.weather_view.model.WeatherData
import com.github.yeeun_yun97.clone.weather_view.model.WeatherResponse
import com.github.yeeun_yun97.clone.weather_view.secret.SecretKeys
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel : ViewModel() {
    var weatherData: MutableLiveData<WeatherData> = MutableLiveData(WeatherData("맑음", 0))

    init {
        loadWeather()
    }

    private fun loadWeather() {
        val response = WeatherApi.getWeatherService()
            .getWeatherData(37.0, 126.0, SecretKeys.APP_D)
        val callback = object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                var temperature: Int = response.body()!!.main.get("temp")!!.toDouble().toInt()
                val status: String = when (response.body()!!.weather[0]["main"]!!) {
                    "sunny" -> "맑음"
                    else -> "흐림"
                }
                Log.i("Weather Service Success", "온도: ${temperature}, 날씨: ${status}")
                weatherData.postValue(weatherData.value!!.copy(temperature=temperature,status=status))
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.i("Weather Service failed", t.stackTraceToString())
            }
        }
        response.enqueue(callback)
    }
}