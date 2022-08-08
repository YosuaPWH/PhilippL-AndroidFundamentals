package com.kotlin.philippl_androidfundamentals

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.philippl_androidfundamentals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Android Fundamentals"

        binding.btnActvImage.setOnClickListener {
            Intent(this, ImageActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.btnCkboxRdio.setOnClickListener {
            Intent(this, CheckboxRadioActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnToasts.setOnClickListener {
            startActivity(Intent(this, ToastsActivity::class.java))
        }

        binding.btnForm.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
    }

}