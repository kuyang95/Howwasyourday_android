package com.pang.howwasyourday

import android.util.Log
import java.util.*

fun getOneDayIntervalTime(): Long{

    val currentDate = Calendar.getInstance()
    val dueDate = Calendar.getInstance().apply {
/*
        set(Calendar.HOUR_OF_DAY, 3)
        set(Calendar.MINUTE, 59)
        set(Calendar.SECOND, 0)
        */

    add(Calendar.MINUTE, 1)


    }

   /* if (dueDate.before(currentDate))
        dueDate.add(Calendar.MINUTE, 1)*/


    return dueDate.timeInMillis - currentDate.timeInMillis
}