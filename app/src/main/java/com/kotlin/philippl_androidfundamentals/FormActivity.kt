package com.kotlin.philippl_androidfundamentals

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.databinding.FormBinding

class FormActivity : AppCompatActivity() {

    private lateinit var binding: FormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Form Activity"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnSubmit.setOnClickListener {
            val firstName = binding.edtFirstName.text.toString()
            val lastName = binding.edtLastName.text.toString()
            val email = binding.edtEmail.text.toString()
            val genderGroup = binding.pickGender.checkedRadioButtonId
            val gender = findViewById<RadioButton>(genderGroup)

            if (firstName != "" && lastName != "" && email != "" && gender != null) {
                binding.DataForm.text = resources.getString(R.string.form, firstName, lastName, email, gender.text)
            } else {
                Toast.makeText(this, "Isi semuanyaaa!!!", Toast.LENGTH_SHORT).show()
                binding.DataForm.text = ""
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}