package com.github.yeeun_yun97.clone.weather_view.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.yeeun_yun97.clone.weather_view.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.ActivityMain_root, CurrencyConverterFragment.newInstance())
        transaction.commit()
    }
}