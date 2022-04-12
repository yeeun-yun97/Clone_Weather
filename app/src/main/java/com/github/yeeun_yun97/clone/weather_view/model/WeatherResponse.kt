package com.github.yeeun_yun97.clone.weather_view.model

data class WeatherResponse(
    val weather:List<Map<String,String>>,
    val main:Map<String,String>,
    val cod: Int
)