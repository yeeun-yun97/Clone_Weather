package com.github.yeeun_yun97.clone.weather_view.model

import com.github.yeeun_yun97.clone.weather_view.R

data class WeatherData(var status: String, var temperature: Int) {
    var icon: Int = iconMap.get(status)!!

    companion object {
        val iconMap: HashMap<String, Int> = hashMapOf(
            "맑음" to R.drawable.ic_baseline_wb_sunny_24,
            "흐림" to R.drawable.ic_baseline_cloud_24
        )
    }
}