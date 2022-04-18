package com.github.yeeun_yun97.clone.weather_view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.yeeun_yun97.clone.weather_view.R
import com.github.yeeun_yun97.clone.weather_view.databinding.FragmentShimmerWeatherPageBinding
import com.github.yeeun_yun97.clone.weather_view.ui.basic.BasicBindingFragment

class WeatherShimmerFragment : BasicBindingFragment<FragmentShimmerWeatherPageBinding>(){
    override fun layoutId(): Int = R.layout.fragment_shimmer_weather_page

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.shimmer.startShimmer()
        return binding.root
    }
}