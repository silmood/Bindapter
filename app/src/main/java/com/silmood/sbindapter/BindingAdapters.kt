package com.silmood.sbindapter

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

@BindingAdapter("imgUrl")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
            .load(url)
            .into(imageView)
}

@BindingAdapter("ratingColor")
fun ratingColor(textView: TextView, ratingPercent: String) {
    val percantage = ratingPercent.toInt()
    val context = textView.context

    val color = when {
        percantage > 95 -> ContextCompat.getColor(context, R.color.positive_1)
        percantage > 90 -> ContextCompat.getColor(context, R.color.positive_2)
        else -> ContextCompat.getColor(context, R.color.negative)
    }

    textView.setTextColor(color)
}