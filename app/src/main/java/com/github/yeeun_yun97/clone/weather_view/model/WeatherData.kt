package com.github.yeeun_yun97.clone.weather_view.model

import com.github.yeeun_yun97.clone.weather_view.R

data class WeatherData(private val _status: String, private val _temperature: Int) {
    val status: String get() = statusMap.get(_status) ?: "흐림"
    val icon: Int get() = iconMap.get(status)!!
    val temperature: String get() = "${_temperature}°C"

    companion object {
        private val iconMap: HashMap<String, Int> = hashMapOf(
            "맑음" to R.drawable.ic_baseline_wb_sunny_24,
            "흐림" to R.drawable.ic_baseline_cloud_24
        )
        private val statusMap: HashMap<String, String> = hashMapOf(
            "sunny" to "맑음",
            "cloudy" to "흐림"
        )
    }
}