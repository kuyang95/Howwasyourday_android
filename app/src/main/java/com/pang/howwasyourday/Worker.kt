package com.pang.howwasyourday

import android.content.Context
import android.util.Log
import androidx.work.*
import java.lang.Exception
import java.util.concurrent.TimeUnit

class Worker(appContext:Context, parameters: WorkerParameters) : CoroutineWorker(appContext, parameters) {


    companion object{
        const val WORK_NAME = "Notification Work"
    }

    override suspend fun doWork(): Result {

        try {

            Log.e(WORK_NAME, "DoWork")
            sendNotification(applicationContext)

            val constraints = Constraints.Builder()
                .build()

            val oneTimeWorkRequest = OneTimeWorkRequestBuilder<Worker>()
                .setInitialDelay(getOneDayIntervalTime(), TimeUnit.MILLISECONDS)
                .setConstraints(constraints).build()

            WorkManager.getInstance(applicationContext).enqueueUniqueWork(WORK_NAME, ExistingWorkPolicy.REPLACE, oneTimeWorkRequest)

        }catch (e: Exception){
            Result.retry()
        }

        return Result.success()
    }

}