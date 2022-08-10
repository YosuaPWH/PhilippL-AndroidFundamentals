package com.kotlin.philippl_androidfundamentals

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.kotlin.philippl_androidfundamentals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Android Fundamentals"

        binding.btnActvImage.setOnClickListener {
            Intent(this, ImageActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.btnCkboxRdio.setOnClickListener {
            Intent(this, CheckboxRadioActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnToasts.setOnClickListener {
            startActivity(Intent(this, ToastsActivity::class.java))
        }

        binding.btnForm.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }

        binding.btnRequestPermission.setOnClickListener {
            requestPermissions()
        }

        binding.btnImplicitIntents.setOnClickListener {
            startActivity(Intent(this, ImplicitIntentsActivity::class.java))
        }

        binding.btnToolbarMenu.setOnClickListener {
            startActivity(Intent(this, ToolbarMenuActivity::class.java))
        }

        binding.btnAlertDialog.setOnClickListener {
            startActivity(Intent(this, AlertDialogActivity::class.java))
        }

    }

    private fun hasWriteExternalStoragePermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForegroundPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationBackgroundPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun requestPermissions() {
        var permissionToRequest = mutableListOf<String>()
        if (!hasWriteExternalStoragePermission())
           permissionToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (!hasLocationForegroundPermission())
            permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)

        if (!hasLocationBackgroundPermission() && hasLocationForegroundPermission())
            permissionToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)

        if (permissionToRequest.isNotEmpty())
            ActivityCompat.requestPermissions(this, permissionToRequest.toTypedArray(), 0)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty())
            for (i in grantResults.indices)
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
                    Log.d("PermissionRequest", "${permissions[i]} granted")
    }



}