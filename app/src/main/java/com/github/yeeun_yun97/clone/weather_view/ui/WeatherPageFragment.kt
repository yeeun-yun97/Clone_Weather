package com.github.yeeun_yun97.clone.weather_view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.github.yeeun_yun97.clone.weather_view.R
import com.github.yeeun_yun97.clone.weather_view.databinding.FragmentWeatherPageBinding
import com.github.yeeun_yun97.clone.weather_view.ui.basic.BasicBindingFragment
import com.github.yeeun_yun97.clone.weather_view.viewmodel.WeatherViewModel

class WeatherPageFragment : BasicBindingFragment<FragmentWeatherPageBinding>() {
    private val weatherViewModel: WeatherViewModel by activityViewModels()

    override fun layoutId(): Int = R.layout.fragment_weather_page

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.viewModel = weatherViewModel

        return binding.root
    }
}