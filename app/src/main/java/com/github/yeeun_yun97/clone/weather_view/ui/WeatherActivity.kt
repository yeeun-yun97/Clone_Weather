package com.github.yeeun_yun97.clone.weather_view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.yeeun_yun97.clone.weather_view.R

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.ConstraintLayout, WeatherPageFragment.newInstance())
        transaction.commit()
    }
}