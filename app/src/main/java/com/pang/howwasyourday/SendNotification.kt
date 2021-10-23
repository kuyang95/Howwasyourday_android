package com.pang.howwasyourday

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


fun sendNotification(context: Context) {
// notification 빌더 (아이콘, 텍스트등 설정 여기서 함)

    lateinit var manager : NotificationManager
    lateinit var channel: NotificationChannel

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        channel = NotificationChannel("hi", "hello", NotificationManager.IMPORTANCE_HIGH)

        manager.createNotificationChannel(channel)
    }

    var builder = NotificationCompat.Builder(
        context,"hi"
    )
        .setSmallIcon(android.R.drawable.ic_menu_call)
        .setLargeIcon(createRoundBitmapIcon(R.drawable.mouse_large,context))
        .setContentTitle("엄마")
        .setContentText("오늘 하루 어땠어?")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setAutoCancel(false)

    NotificationManagerCompat.from(context).notify(1,builder.build())

}