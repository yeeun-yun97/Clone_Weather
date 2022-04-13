package com.github.yeeun_yun97.clone.weather_view

import com.github.yeeun_yun97.clone.weather_view.model.WeatherResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    companion object {
        fun getWeatherService(): WeatherApi {
            return Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApi::class.java)
        }
    }

    @GET("data/2.5/weather/")
    fun getWeatherData(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") appId: String,
        @Query("units") lang: String = "Metric"
    ): Call<WeatherResponse>
}