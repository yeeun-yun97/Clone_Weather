package com.github.yeeun_yun97.clone.weather_view

import android.widget.ImageView
import androidx.databinding.BindingAdapter


class WeatherBindingAdapter {

    companion object{
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageView(imageView: ImageView, resId: Int) {
            imageView.setImageResource(resId)
        }
    }

}