package com.kotlin.philippl_androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kotlin.philippl_androidfundamentals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindMainActivity: ActivityMainBinding
    private val aa = MainActivityFragmentFirst()
    private val bb = MainActivityFragmentSecond()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMainActivity.root)

        supportActionBar?.title = "Android Fundamentals"
        makeCurrentFragment(aa)

        bindMainActivity.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.miHome -> makeCurrentFragment(aa)
                R.id.miMessage -> makeCurrentFragment(bb)
            }
            true
        }

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.next -> startActivity(Intent(this, MainActivity2::class.java))
//        }
//        return true
//    }

    private fun makeCurrentFragment(frg: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flActivityMain, frg)
//            addToBackStack(null)
            commit()
        }
    }

//    private fun hasWriteExternalStoragePermission() =
//        ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
//
//    private fun hasLocationForegroundPermission() =
//        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
//
//    private fun hasLocationBackgroundPermission() =
//        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
//
//    private fun requestPermissions() {
//        var permissionToRequest = mutableListOf<String>()
//        if (!hasWriteExternalStoragePermission())
//            permissionToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//
//        if (!hasLocationForegroundPermission())
//            permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
//
//        if (!hasLocationBackgroundPermission() && hasLocationForegroundPermission())
//            permissionToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
//
//        if (permissionToRequest.isNotEmpty())
//            ActivityCompat.requestPermissions(this, permissionToRequest.toTypedArray(), 0)
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == 0 && grantResults.isNotEmpty())
//            for (i in grantResults.indices)
//                if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
//                    Log.d("PermissionRequest", "${permissions[i]} granted")
//    }





}