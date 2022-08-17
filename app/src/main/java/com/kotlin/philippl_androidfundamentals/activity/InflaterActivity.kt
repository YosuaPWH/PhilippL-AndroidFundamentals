package com.kotlin.philippl_androidfundamentals.activity

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.R
import com.kotlin.philippl_androidfundamentals.databinding.ActivityInflaterBinding

class InflaterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInflaterBinding
    private lateinit var sub1: View
    private lateinit var sub2: View
    private lateinit var konten: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInflaterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Inflater"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        konten = findViewById(R.id.konten_view)

        sub1 = layoutInflater.inflate(R.layout.activity_inflater_sub1, konten, false)
        sub2 = layoutInflater.inflate(R.layout.activity_inflater_sub2, konten, false)

        konten.addView(sub1)
        konten.addView(sub2)

        val konten = binding.root.findViewById<LinearLayout>(R.id.konten_view)
        konten.setBackgroundColor(resources.getColor(R.color.teal_700, theme))

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}