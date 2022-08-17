package com.kotlin.philippl_androidfundamentals.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.philippl_androidfundamentals.Person
import com.kotlin.philippl_androidfundamentals.R
import com.kotlin.philippl_androidfundamentals.databinding.ActivityFormIntentBinding

class FormIntentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Form Intent Activity"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        binding.intentTextView.text = resources.getString(
            R.string.form,
            person.firstName,
            person.lastName,
            person.email,
            person.gender
        )

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}