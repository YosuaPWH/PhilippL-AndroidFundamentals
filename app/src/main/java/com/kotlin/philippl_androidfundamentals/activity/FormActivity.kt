package com.kotlin.philippl_androidfundamentals.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kotlin.philippl_androidfundamentals.Person
import com.kotlin.philippl_androidfundamentals.R
import com.kotlin.philippl_androidfundamentals.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
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

                val person = Person(firstName, lastName, email, gender.text.toString())
                Intent(this, FormIntentActivity::class.java).apply {
                    this.putExtra("EXTRA_PERSON", person)
                    startActivity(this)
                }

            } else {
//                Toast.makeText(this, "Isi semuanyaaa!!!", Toast.LENGTH_SHORT).show()
                val contextView = findViewById<View>(R.id.btn_submit)
                Snackbar.make(contextView, "Mohon diisi semuanya!!", Snackbar.LENGTH_SHORT)
                    .setAction("Okay!") {}
                    .setActionTextColor(resources.getColor(R.color.black))
                    .setBackgroundTint(resources.getColor(R.color.purple_200))
                    .show()
                binding.DataForm.text = ""
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}