package com.kotlin.philippl_androidfundamentals.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.kotlin.philippl_androidfundamentals.MainActivity
import com.kotlin.philippl_androidfundamentals.R
import com.kotlin.philippl_androidfundamentals.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationBinding
    private val CHANNEL_ID = "channelID"
    private val CHANNEL_NAME = "channelName"
    private val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Notification"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        createNotificationChannel()

        val intent = Intent(this, MainActivity::class.java)

        // Ketika notif diklik, akan masuk kedalam notificationActivity
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }


        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Learning Notification")
            .setContentText("This my first notification in Android")
            .setSmallIcon(R.drawable.ic_star)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent) // kode ketika notif diklik
            .build()

        val notificationManager = NotificationManagerCompat.from(this)

        binding.btnSetNotification.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}