package com.github.yeeun_yun97.clone.weather_view.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("weather")
    val weather:List<Map<String,String>>,
    @SerializedName("main")
    val main:Map<String,String>,
    @SerializedName("code")
    val code: Int
)