package com.kotlin.philippl_androidfundamentals.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.databinding.ActivityIntentServiceBinding

class MainIntentServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Intent Service"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnStartService.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                binding.tvStatus.text = "Service running"
            }
        }

        binding.btnStopService.setOnClickListener {
            MyIntentService.stopService()
            binding.tvStatus.text = "Service stopped"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}