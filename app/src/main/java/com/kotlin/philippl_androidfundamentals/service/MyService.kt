package com.kotlin.philippl_androidfundamentals.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    val TAG = "MyService"

    init {
        Log.d(TAG, "Service is running...")
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG, dataString)
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Service is being killed")
    }
}