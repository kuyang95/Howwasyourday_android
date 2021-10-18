package com.pang.howwasyourday

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var builder = NotificationCompat.Builder(this, createNotificationChannel("first", "mainNoti"))
            .setSmallIcon(android.R.drawable.ic_menu_call)
            .setContentTitle("엄마")
            .setContentText("오늘 하루 어땠어?")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(false)


        pushNotify(builder)

    }

    private fun createNotificationChannel(id: String, name: String) : String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)

            manager.createNotificationChannel(channel)
        }
      return id
    }

    private fun pushNotify(builder : NotificationCompat.Builder) = with(NotificationManagerCompat.from(this)){
        notify(1, builder.build())
    }

}