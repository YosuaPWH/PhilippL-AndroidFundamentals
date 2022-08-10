package com.kotlin.philippl_androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class ToolbarMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addContacts -> snackbar("You clicked on Add Contact")
            R.id.favorites -> snackbar("You clicked on Favorite")
            R.id.settings -> snackbar("You clicked on Setting")
            R.id.feedback -> snackbar("You clicked on Feedback")
            R.id.backMain -> onBackPressed()
        }
        return true
    }

    private fun snackbar(str: String) {
        val contextView = findViewById<View>(R.id.btnTest)
        Snackbar.make(contextView, str, Snackbar.LENGTH_SHORT)
            .setAction("Okay!") {}
            .setActionTextColor(resources.getColor(R.color.white))
            .setBackgroundTint(resources.getColor(R.color.purple_500))
            .show()
    }
}