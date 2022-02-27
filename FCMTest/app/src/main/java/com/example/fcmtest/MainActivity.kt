package com.example.fcmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fcmtest.MyFirebaseMessagingService.Companion.getDeviceToken

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDeviceToken()
    }
}