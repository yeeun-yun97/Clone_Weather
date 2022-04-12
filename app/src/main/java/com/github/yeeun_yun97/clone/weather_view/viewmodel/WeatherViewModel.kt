package com.github.yeeun_yun97.clone.weather_view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.yeeun_yun97.clone.weather_view.model.WeatherData

class WeatherViewModel :ViewModel(){
    val weatherData: MutableLiveData<WeatherData> by lazy { loadWeather() }

    private fun loadWeather(): MutableLiveData<WeatherData> {
        return MutableLiveData(WeatherData("흐림", 18))
    }

}