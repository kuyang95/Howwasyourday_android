package com.pang.howwasyourday

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.*
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.lang.Integer.min

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // notification 빌더 (아이콘, 텍스트등 설정 여기서 함)
        var builder = NotificationCompat.Builder(this, createNotificationChannel("first", "mainNoti"))
            .setSmallIcon(android.R.drawable.ic_menu_call)
            .setLargeIcon(createRoundBitmapIcon(R.drawable.mouse_large))
            .setContentTitle("엄마")
            .setContentText("오늘 하루 어땠어?")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(false)


        pushNotify(builder)

    }


    private fun createRoundBitmapIcon(imageRes : Int) : Bitmap {
       var bitmap : Bitmap = BitmapFactory.decodeResource(resources,imageRes)
        bitmap = getCircularBitmap(bitmap)
        return bitmap
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

    // 사진 동그랗게 크롭하는 함수
    @RequiresApi(Build.VERSION_CODES.N)
    private fun getCircularBitmap(srcBitmap: Bitmap?): Bitmap {

        // Select whichever of width or height is minimum
        val squareBitmapWidth = min(srcBitmap!!.width, srcBitmap.height)

        // Generate a bitmap with the above value as dimensions
        val dstBitmap = Bitmap.createBitmap(
            squareBitmapWidth,
            squareBitmapWidth,
            Bitmap.Config.ARGB_8888
        )

        // Initializing a Canvas with the above generated bitmap
        val canvas = Canvas(dstBitmap)

        // initializing Paint
        val paint = Paint()
        paint.isAntiAlias = true

        // Generate a square (rectangle with all sides same)
        val rect = Rect(0, 0, squareBitmapWidth, squareBitmapWidth)
        val rectF = RectF(rect)

        // Operations to draw a circle
        canvas.drawOval(rectF, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        val left = ((squareBitmapWidth - srcBitmap.width) / 2).toFloat()
        val top = ((squareBitmapWidth - srcBitmap.height) / 2).toFloat()
        canvas.drawBitmap(srcBitmap, left, top, paint)
        srcBitmap.recycle()

        // Return the bitmap
        return dstBitmap
    }

    // 노티 발송
    private fun pushNotify(builder : NotificationCompat.Builder) = with(NotificationManagerCompat.from(this)){
        notify(1, builder.build())
    }

}