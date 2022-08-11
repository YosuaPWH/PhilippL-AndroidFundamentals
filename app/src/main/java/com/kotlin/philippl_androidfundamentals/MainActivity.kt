package com.kotlin.philippl_androidfundamentals

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.kotlin.philippl_androidfundamentals.activity.*
import com.kotlin.philippl_androidfundamentals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindMainActivity: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMainActivity.root)

        supportActionBar?.title = "Android Fundamentals"

        bindMainActivity.btnActvImage.setOnClickListener {
            Intent(this, ImageActivity::class.java).apply {
                startActivity(this)
            }
        }

        bindMainActivity.btnCkboxRdio.setOnClickListener {
            Intent(this, CheckboxRadioActivity::class.java).also {
                startActivity(it)
            }
        }

        bindMainActivity.btnToasts.setOnClickListener {
            startActivity(Intent(this, ToastsActivity::class.java))
        }

        bindMainActivity.btnForm.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }

        bindMainActivity.btnRequestPermission.setOnClickListener {
            requestPermissions()
        }

        bindMainActivity.btnImplicitIntents.setOnClickListener {
            startActivity(Intent(this, ImplicitIntentsActivity::class.java))
        }

        bindMainActivity.btnToolbarMenu.setOnClickListener {
            startActivity(Intent(this, ToolbarMenuActivity::class.java))
        }

        bindMainActivity.btnAlertDialog.setOnClickListener {
            startActivity(Intent(this, AlertDialogActivity::class.java))
        }

        bindMainActivity.btnInflaterActivity.setOnClickListener {
            startActivity(Intent(this, InflaterActivity::class.java))
        }

        bindMainActivity.btnSpinner.setOnClickListener {
            Intent(this, SpinnerActivity::class.java).apply {
                startActivity(this)
            }
        }

        bindMainActivity.btnRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerViewTodoAppActivity::class.java))
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