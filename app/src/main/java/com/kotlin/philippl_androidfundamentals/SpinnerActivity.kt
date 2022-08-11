package com.kotlin.philippl_androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.kotlin.philippl_androidfundamentals.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpinnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Spinner"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.spinnerBulan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext, "You selected ${adapterView?.getItemAtPosition(position).toString()}", Toast.LENGTH_SHORT).show()
                binding.tvBulan.text = adapterView?.getItemAtPosition(position).toString()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}