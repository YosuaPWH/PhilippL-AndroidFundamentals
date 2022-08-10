package com.kotlin.philippl_androidfundamentals

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.databinding.ActivityImplicitIntentsBinding

class ImplicitIntentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImplicitIntentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImplicitIntentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Implicit Intents"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnGetPhoto.setOnClickListener {
            // DEPRECATED
//            Intent(Intent.ACTION_GET_CONTENT).also {
//                it.type = "image/*"
//                startActivityForResult(it, 0)
//            }

            getImage.launch("image/*")
        }

    }

    private val getImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        binding.imageView.setImageURI(uri)
    }

    // DEPRECATED
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
//            val uri = data?.data
//            binding.imageView.setImageURI(uri)
//        }
//    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}