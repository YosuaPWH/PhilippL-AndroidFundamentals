package com.kotlin.philippl_androidfundamentals.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPreferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Shared Preferences"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sharedPref = getSharedPreferences("MyPreferences", MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.btnSave.setOnClickListener {
            val firstName = binding.edtFirstName.text.toString()
            val lastName = binding.edtLastName.text.toString()
            val age = binding.edtAge.text.toString()
            val isAdult = binding.cbIsAdult.isChecked

            editor.apply {
                if (firstName.trim() == "") {
                    putString("firstName", "")
                } else {
                    putString("firstName", firstName)
                }

                if (lastName.trim() == "") {
                    putString("lastName", "")
                } else {
                    putString("lastName", lastName)
                }

                if (age.trim() == "") {
                    putInt("age", 0)
                } else {
                    putInt("age", age.toInt())
                }

                putBoolean("isAdult", isAdult)
                apply()
            }
        }

        binding.btnLoad.setOnClickListener {
            val firstName = sharedPref.getString("firstName", "")
            val lastName = sharedPref.getString("lastName", "")
            val age = sharedPref.getInt("age", 0).toString()
            val isAdult = sharedPref.getBoolean("isAdult", false)

            binding.edtFirstName.setText(firstName)
            binding.edtLastName.setText(lastName)
            binding.edtAge.setText(age)
            binding.cbIsAdult.isChecked = isAdult

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}