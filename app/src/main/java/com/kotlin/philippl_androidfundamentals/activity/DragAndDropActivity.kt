package com.kotlin.philippl_androidfundamentals.activity

import android.content.ClipData
import android.content.ClipDescription
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.philippl_androidfundamentals.databinding.ActivityDragAndDropBinding

class DragAndDropActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDragAndDropBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDragAndDropBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Drag And Drop"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.llTop.setOnDragListener(dragListener)
        binding.llBottom.setOnDragListener(dragListener)

        binding.dragView.setOnLongClickListener {
            val clipText = "This is our ClipData text"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)
//
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }
    }

    private val dragListener = View.OnDragListener { view, event ->
        when(event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                val item = event.clipData.getItemAt(0)
                val dragData = item.text
                Toast.makeText(this, dragData, Toast.LENGTH_SHORT).show()

                view.invalidate()

                val v = event.localState as View
                val owner = v.parent as ViewGroup
                owner.removeView(v)

                val destination = view as LinearLayout
                destination.addView(v)
                v.visibility = View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                view.invalidate()
                true
            }
            else -> false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}