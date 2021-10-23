package com.pang.howwasyourday

import android.app.Application
import android.util.Log
import androidx.work.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class WorkApplication : Application() {
    companion object{
        const val TAG = "WorkApplication"
    }

    private val backgroundCoroutineScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        delayCreateWork()
    }

    private fun delayCreateWork(){
        backgroundCoroutineScope.launch {
            createWorkManager()
        }
    }

    private fun createWorkManager(){
        val constraints = Constraints.Builder()
            .build()

        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<Worker>()
            .setInitialDelay(getOneDayIntervalTime(), TimeUnit.MILLISECONDS)
            .setConstraints(constraints).build()

        sendNotification(applicationContext)
        Log.e(TAG, "Init WorkManager")
        WorkManager.getInstance(applicationContext).enqueueUniqueWork(Worker.WORK_NAME, ExistingWorkPolicy.KEEP, oneTimeWorkRequest)
    }

}