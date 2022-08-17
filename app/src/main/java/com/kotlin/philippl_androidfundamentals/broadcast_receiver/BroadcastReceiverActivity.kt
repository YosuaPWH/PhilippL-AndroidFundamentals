package com.kotlin.philippl_androidfundamentals.broadcast_receiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.R

class BroadcastReceiverActivity : AppCompatActivity() {

    private lateinit var receiver: AirplaneModeChangedReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)
        supportActionBar?.title = "Broadcast Receiver"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        receiver = AirplaneModeChangedReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).apply {
            registerReceiver(receiver, this)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}