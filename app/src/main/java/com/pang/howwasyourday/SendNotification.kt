package com.pang.howwasyourday

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput


fun sendNotification(context: Context) {
// notification 빌더 (아이콘, 텍스트등 설정 여기서 함)

    lateinit var manager : NotificationManager
    lateinit var channel: NotificationChannel

    val remoteInput = RemoteInput.Builder("key_text_reply")
        .build()

    val resultIntent = Intent(context, NotificationReceiver::class.java)

    val resultPendingIntent = PendingIntent.getBroadcast(
        context,
        0,
        resultIntent,
        0
    )

    val action : NotificationCompat.Action = NotificationCompat.Action.Builder(
    R.drawable.mouse_large,
        "Reply",
        resultPendingIntent)
        .addRemoteInput(remoteInput)
        .setAllowGeneratedReplies(true)
        .build()




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
        .addAction(action)
        .setAutoCancel(false)

    NotificationManagerCompat.from(context).notify(1,builder.build())

}

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
       val remoteInput = RemoteInput.getResultsFromIntent(p1)

        if (remoteInput != null){
            val title = remoteInput.getCharSequence(
                "key_text_reply")

        }
    }
}