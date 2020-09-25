package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun doWorkOneTime() {
        val workRequest = OneTimeWorkRequestBuilder<MyWorker>().build()
        val workManager = WorkManager.getInstance()
        workManager.enqueue(workRequest)
    }

    private fun doWorkPeriodic() {
        val workRequest = PeriodicWorkRequestBuilder<MyWorker>(15, TimeUnit.MINUTES).build()
        PeriodicWorkRequest.Builder(MyWorker::class.java, 15, TimeUnit.MINUTES).build()
        val workManager = WorkManager.getInstance()
        workManager.enqueue(workRequest)
    }
}