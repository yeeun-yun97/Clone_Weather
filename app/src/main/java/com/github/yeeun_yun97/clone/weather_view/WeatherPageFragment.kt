package com.github.yeeun_yun97.clone.weather_view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.yeeun_yun97.clone.weather_view.databinding.FragmentWeatherPageBinding
import com.github.yeeun_yun97.clone.weather_view.model.WeatherData
import com.github.yeeun_yun97.clone.weather_view.viewmodel.WeatherViewModel

class WeatherPageFragment : Fragment() {
    private lateinit var weatherViewModel:WeatherViewModel

    companion object{
        fun newInstance(weatherViewModel:WeatherViewModel):WeatherPageFragment{
            val fragment = WeatherPageFragment()
            fragment.weatherViewModel=weatherViewModel
            return fragment
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWeatherPageBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_weather_page, container, false)
        binding.weatherViewModel = weatherViewModel
        return binding.root
    }
}