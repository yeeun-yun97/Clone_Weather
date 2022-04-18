package com.github.yeeun_yun97.clone.weather_view.repository

import com.github.yeeun_yun97.clone.weather_view.WeatherApi
import com.github.yeeun_yun97.clone.weather_view.model.WeatherResponse
import com.github.yeeun_yun97.clone.weather_view.secret.SecretKeys
import retrofit2.Response
import retrofit2.awaitResponse

class WeatherRepository {
    private val service = WeatherApi.getWeatherService()

    suspend fun loadWeatherData(): Response<WeatherResponse> =
        service.getWeatherData(
            37.0,
            128.0,
            SecretKeys.APP_D
        )
}