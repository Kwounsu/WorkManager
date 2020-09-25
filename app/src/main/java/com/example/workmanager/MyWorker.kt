package com.example.workmanager

import android.content.Context
import androidx.work.Worker
import android.util.Log
import androidx.work.WorkerParameters

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        Log.d("MyLog", "MyWorker is Working...")
        return Result.success()
    }
}