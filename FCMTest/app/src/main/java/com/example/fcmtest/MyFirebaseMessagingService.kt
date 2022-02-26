package com.example.fcmtest

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.os.Build.*
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelID = "notification_channel"
const val channelName = "com.example.fcmtest"

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        if (remoteMessage.data.isNotEmpty()) {

        }

        remoteMessage.notification?.let {

            sendNotification(it.title!!, it.body!!)
        }
    }

    private fun sendNotification(title: String, text: String) {

        // 푸시알림 클릭 했을 때 이동할 Activity 지정
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 /* Request code */, intent,
            PendingIntent.FLAG_ONE_SHOT
        )

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
            .setContent(getRemoteView(title, text))
        // 커스텀 토스트를 사용하지 않고, 안드로이드 디폴트 푸시알림을 사용하려면
        // 위 setContent() 한 줄을 지우고 setContentTitle(), setContentText()를 추가하면됨
        //.setContentTitle(title)
        //.setContentText(text)


        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        /** Oreo Version 이하일때 처리 하는 코드 */
        if (VERSION.SDK_INT >= VERSION_CODES.O) {
            val notificationChannel =
                NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0, notificationBuilder.build())
    }

    // 푸시알림 커스텀 하는 메소드
    @SuppressLint("RemoteViewLayout")
    private fun getRemoteView(title: String, text: String): RemoteViews {
        val remoteView = RemoteViews("com.example.fcmtest", R.layout.push_notification)
        remoteView.setTextViewText(R.id.tv_title, title)
        remoteView.setTextViewText(R.id.tv_description, text)
        remoteView.setImageViewResource(R.id.iv_image, R.drawable.ic_launcher_foreground)

        return remoteView
    }

    companion object {
        fun getDeviceToken() {
            FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.d("TokenTest", "Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new FCM registration token
                val token = task.result
                if (token != null) {
                    Log.d("TokenTest", token)
                }
            })
        }

        private const val TAG = "MyFirebaseMessagingService"
    }
}