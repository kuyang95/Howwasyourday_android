package com.pang.howwasyourday

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.os.Build
import androidx.annotation.RequiresApi


fun createRoundBitmapIcon(imageRes : Int, context: Context) : Bitmap {

    var bitmap : Bitmap = BitmapFactory.decodeResource(context.resources,imageRes)
    bitmap = getCircularBitmap(bitmap)
    return bitmap
}


// 사진 동그랗게 크롭하는 함수
@RequiresApi(Build.VERSION_CODES.N)
fun getCircularBitmap(srcBitmap: Bitmap?): Bitmap {

    // Select whichever of width or height is minimum
    val squareBitmapWidth = Integer.min(srcBitmap!!.width, srcBitmap.height)

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