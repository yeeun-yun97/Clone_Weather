package com.github.yeeun_yun97.clone.weather_view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.github.yeeun_yun97.clone.weather_view.R
import com.github.yeeun_yun97.clone.weather_view.model.WeatherData
import com.github.yeeun_yun97.clone.weather_view.viewmodel.WeatherViewModel

class WeatherActivity : AppCompatActivity() {
    val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.ConstraintLayout, WeatherShimmerFragment())
        transaction.commit()

        val loadingObserver = Observer<WeatherData> { data ->
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.ConstraintLayout, WeatherPageFragment())
            transaction.commit()
        }
        weatherViewModel.weatherData.observe(this,loadingObserver)

        this.weatherViewModel.loadWeatherData()

    }
}