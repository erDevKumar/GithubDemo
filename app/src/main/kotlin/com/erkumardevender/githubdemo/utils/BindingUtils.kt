package com.erkumardevender.githubdemo.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.erkumardevender.githubdemo.R
import java.text.SimpleDateFormat
import java.util.*

object BindingUtils {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageUrl(imageView: ImageView,url:String?){
        Glide.with(imageView).load(url).placeholder(R.drawable.ic_person).into(imageView)
    }

    @BindingAdapter("dateTime")
    @JvmStatic
    fun setDateTime(textView: TextView,dateTime:String){
        val simpleDateFormatIn=SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",Locale.getDefault())
        val simpleDateFormatOut=SimpleDateFormat("MMM dd, yyyy",Locale.getDefault())
        textView.text = simpleDateFormatOut.format(simpleDateFormatIn.parse(dateTime)!!)
    }
}