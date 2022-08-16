package com.kotlin.philippl_androidfundamentals.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.R
import com.kotlin.philippl_androidfundamentals.databinding.ActivitySlideableMainBinding

class SlideableMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySlideableMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlideableMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Slideable Menu"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.myItem1 -> Toast.makeText(
                    applicationContext,
                    "Clicked Item 1", Toast.LENGTH_SHORT
                ).show()

                R.id.miViewPager -> startActivity(Intent(this, ViewPagerActivity::class.java))

                R.id.miReturn -> finish()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}