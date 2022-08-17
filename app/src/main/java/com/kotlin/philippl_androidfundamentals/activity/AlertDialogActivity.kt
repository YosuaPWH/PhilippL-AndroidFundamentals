package com.kotlin.philippl_androidfundamentals.activity

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.kotlin.philippl_androidfundamentals.R
import com.kotlin.philippl_androidfundamentals.databinding.ActivityAlertDialogBinding

class AlertDialogActivity : AppCompatActivity() {

    private lateinit var bindAlertDialog: ActivityAlertDialogBinding
    private val options = arrayOf("First Item", "Second Item", "Third Item")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindAlertDialog = ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(bindAlertDialog.root)
        supportActionBar?.title = "Alert Dialog"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bindAlertDialog.btnAlert1.setOnClickListener {
            addContactDialog()
        }

        bindAlertDialog.btnAlert2.setOnClickListener {
            singleChoiceDialog()
        }

        bindAlertDialog.btnAlert3.setOnClickListener {
            multiChoiceDialog()
        }
    }

    private fun addContactDialog() {
        AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Mr. Poop to your contacts list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _, _ ->
                Snackbar.make(bindAlertDialog.root, "You add Mr. Poop to your contact list", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(resources.getColor(R.color.purple_500))
                    .show()
            }
            .setNegativeButton("No") { _, _ ->
                Snackbar.make(bindAlertDialog.root, "You didn't add Mr. Poop to your contact list", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(resources.getColor(R.color.purple_500))
                    .show()
            }.show()
    }

    private fun singleChoiceDialog() {
        AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options, 0) { _, i ->
//                Snackbar.make(binding.btnAlert2, "You Clicked on ${options[i]}", Snackbar.LENGTH_SHORT)
//                    .setBackgroundTint(resources.getColor(R.color.purple_500))
//                    .show()
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Snackbar.make(bindAlertDialog.root, "You accepted the SingleChoiceDialog", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(resources.getColor(R.color.purple_500))
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Snackbar.make(bindAlertDialog.btnAlert2, "You declined the SingleChoiceDialog", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(resources.getColor(R.color.purple_500))
                    .show()
            }.show()
    }

    private fun multiChoiceDialog() {
        AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _, _ ->
                Snackbar.make(bindAlertDialog.root, "You accepted the MultiChoiceDialog", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(resources.getColor(R.color.purple_500))
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Snackbar.make(bindAlertDialog.btnAlert2, "You declined the MultiChoiceDialog", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(resources.getColor(R.color.purple_500))
                    .show()
            }.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}

