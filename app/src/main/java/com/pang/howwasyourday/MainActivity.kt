package com.pang.howwasyourday

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // notification 빌더 (아이콘, 텍스트등 설정 여기서 함)
        var builder = NotificationCompat.Builder(this, createNotificationChannel("first", "mainNoti"))
            .setSmallIcon(android.R.drawable.ic_menu_call)
            .setLargeIcon(createBitmapIcon(R.drawable.mouse_large))
            .setContentTitle("엄마")
            .setContentText("오늘 하루 어땠어?")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(false)


        pushNotify(builder)

    }


    private fun createBitmapIcon(imageRes : Int) : Bitmap {
        val mouse_largeIcon : Bitmap = BitmapFactory.decodeResource(getResources(), imageRes)
        return mouse_largeIcon
    }

    // 오레오 이상에서는 노티에 채널 필요해서 생성해줘야 함
    private fun createNotificationChannel(id: String, name: String) : String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)

            manager.createNotificationChannel(channel)
        }
      return id
    }

    // 노티 발송
    private fun pushNotify(builder : NotificationCompat.Builder) = with(NotificationManagerCompat.from(this)){
        notify(1, builder.build())
    }

}