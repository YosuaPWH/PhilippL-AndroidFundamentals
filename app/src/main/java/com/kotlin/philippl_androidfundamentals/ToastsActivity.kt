package com.kotlin.philippl_androidfundamentals

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kotlin.philippl_androidfundamentals.databinding.ToastsBinding

class ToastsActivity : AppCompatActivity() {

    private lateinit var binding: ToastsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ToastsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Toast"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnToast.setOnClickListener {
//            Toast.makeText(this, "Ini adalah Toast", Toast.LENGTH_SHORT).show()
            val contextView = findViewById<View>(R.id.btn_toast)
            Snackbar.make(contextView, "This is Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Okay!") {}
                .setActionTextColor(resources.getColor(R.color.black))
                .setBackgroundTint(resources.getColor(R.color.purple_200))
                .show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}