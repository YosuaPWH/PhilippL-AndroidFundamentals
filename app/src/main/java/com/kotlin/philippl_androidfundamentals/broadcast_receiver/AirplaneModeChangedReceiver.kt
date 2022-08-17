package com.kotlin.philippl_androidfundamentals.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return

        if (isAirplaneModeEnabled) {
            Toast.makeText(context, "Airplane mode enabled", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Airplane mode disabled", Toast.LENGTH_SHORT).show()
        }
    }
}