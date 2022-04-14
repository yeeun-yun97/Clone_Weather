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
    private val weatherViewModel: WeatherViewModel by activityViewModels()
    private lateinit var binding: FragmentWeatherPageBinding

    companion object {
        fun newInstance(): WeatherPageFragment {
            return WeatherPageFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_weather_page, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = weatherViewModel

        weatherViewModel.loadWeatherData(::shimmerStart,::shimmerStop)

        return binding.root
    }

    fun shimmerStart() {
        binding.weatherImageView.visibility=View.GONE
        binding.temperatureTextView.visibility=View.GONE
        binding.textView.visibility=View.GONE
        binding.weatherTextView.visibility=View.GONE

        binding.shimmerLayout.visibility = View.VISIBLE
        binding.shimmerLayout.startShimmer()
    }

    fun shimmerStop(){
        binding.shimmerLayout.visibility = View.GONE

        binding.weatherImageView.visibility=View.VISIBLE
        binding.temperatureTextView.visibility=View.VISIBLE
        binding.textView.visibility=View.VISIBLE
        binding.weatherTextView.visibility=View.VISIBLE

        binding.shimmerLayout.stopShimmer()
    }
}