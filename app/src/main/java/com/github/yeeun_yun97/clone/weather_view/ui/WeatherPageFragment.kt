package com.github.yeeun_yun97.clone.weather_view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.github.yeeun_yun97.clone.weather_view.R
import com.github.yeeun_yun97.clone.weather_view.databinding.FragmentWeatherPageBinding
import com.github.yeeun_yun97.clone.weather_view.viewmodel.WeatherViewModel

class WeatherPageFragment : Fragment() {
    private val weatherViewModel:WeatherViewModel by activityViewModels()

    companion object{
        fun newInstance(): WeatherPageFragment {
            return WeatherPageFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWeatherPageBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_weather_page, container, false)
        binding.lifecycleOwner = this
        binding.viewModel=weatherViewModel
        return binding.root
    }
}