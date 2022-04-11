package com.github.yeeun_yun97.clone.weather_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.github.yeeun_yun97.clone.weather_view.model.WeatherData
import com.github.yeeun_yun97.clone.weather_view.viewmodel.WeatherViewModel

class WeatherActivity : AppCompatActivity() {
    private val weatherViewModel : WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.ConstraintLayout, WeatherPageFragment.newInstance(weatherViewModel))
        transaction.commit()
    }
}