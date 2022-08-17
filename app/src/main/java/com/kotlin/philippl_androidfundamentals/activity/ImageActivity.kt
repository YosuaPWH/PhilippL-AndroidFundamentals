package com.kotlin.philippl_androidfundamentals.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.R
import com.kotlin.philippl_androidfundamentals.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageBinding

    companion object {
        const val EXTRA_IMAGE = "EXTRA_IMAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Image Activity"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnAddimage.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                binding.imgvImage.setImageResource(0)
                finish()
            }, 1000)
            if (intent.getIntExtra(EXTRA_IMAGE, 0) == 0) {
                binding.imgvImage.setImageResource(R.drawable.theworldafterthefall)
            } else {
                binding.imgvImage.setImageResource(intent.getIntExtra(EXTRA_IMAGE, 0))
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}