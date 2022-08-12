package com.kotlin.philippl_androidfundamentals.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.R
import com.kotlin.philippl_androidfundamentals.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Fragment"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val firstFragment = FragmentFirst()
        val secondFragment = FragmentSecond()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentLayout, firstFragment)
            commit()
        }

        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentLayout, firstFragment)
                commit()
            }
        }

        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentLayout, secondFragment)
                commit()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}