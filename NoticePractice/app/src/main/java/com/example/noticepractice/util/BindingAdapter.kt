package com.example.noticepractice.util

import android.widget.ImageView
import com.example.noticepractice.R

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("isCalendar", "isButtonClick")
    fun setNoticeListImage(imageView: ImageView, isCalendar: Boolean, isButtonClick: Boolean) {
        with(imageView) {
            if(isCalendar && isButtonClick) {
                setImageResource(R.drawable.ic_calendar_alarm_gray)
            }else if(isCalendar && !isButtonClick) {
                setImageResource(R.drawable.ic_calendar_alarm_mint)
            }else if(!isCalendar && isButtonClick) {
                setImageResource(R.drawable.ic_fill_alarm_gray)
            } else if(!isCalendar && !isButtonClick) {
                setImageResource(R.drawable.ic_fill_alarm_mint)
            }
        }
    }
}