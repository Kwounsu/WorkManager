package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.work.*
import com.example.workmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            activity = this@MainActivity
        }
    }

    fun doWorkOneTime() {
        val workRequest = OneTimeWorkRequestBuilder<MyWorker>().build()
        val workManager = WorkManager.getInstance()
        workManager.enqueue(workRequest)
    }
}