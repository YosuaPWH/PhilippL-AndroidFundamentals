package com.kotlin.philippl_androidfundamentals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.databinding.ActivityMain2Binding
import com.kotlin.philippl_androidfundamentals.fragment.FragmentActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Android Fundamentals"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnFragment.setOnClickListener {
            startActivity(Intent(this, FragmentActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}