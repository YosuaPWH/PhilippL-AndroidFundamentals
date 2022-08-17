package com.kotlin.philippl_androidfundamentals.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kotlin.philippl_androidfundamentals.R
import com.kotlin.philippl_androidfundamentals.databinding.ActivityToastsBinding

class ToastsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToastsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToastsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Toast"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnToast.setOnClickListener {
//            Toast.makeText(this, "Ini adalah Toast", Toast.LENGTH_SHORT).show()
            val contextView = findViewById<View>(R.id.btn_toast)
            Snackbar.make(contextView, "This is Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Okay!") {}
                .setActionTextColor(resources.getColor(R.color.black, theme))
                .setBackgroundTint(resources.getColor(R.color.purple_200, theme))
                .show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}