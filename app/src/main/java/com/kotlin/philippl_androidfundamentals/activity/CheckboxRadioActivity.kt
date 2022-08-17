package com.kotlin.philippl_androidfundamentals.activity

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.R
import com.kotlin.philippl_androidfundamentals.databinding.CheckboxRadiobuttonBinding

class CheckboxRadioActivity : AppCompatActivity() {

    private lateinit var binding: CheckboxRadiobuttonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CheckboxRadiobuttonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Checkbox & Radio"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnOrder.setOnClickListener {
            val checkRadioButton = binding.rdgroup.checkedRadioButtonId
            val daging = findViewById<RadioButton>(checkRadioButton)
            val keju = binding.keju.isChecked
            val saus = binding.saustomat.isChecked
            val salad = binding.salad.isChecked
            val orderString = "You ordered a burger with:\n" +
                    "${daging.text}" +
                    (if (keju) "\nKeju" else "") +
                    (if (saus) "\nSaus Tomat" else "") +
                    (if (salad) "\nSalad" else "")
            binding.tvText.apply {
                text = orderString
                textSize = 20F
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}