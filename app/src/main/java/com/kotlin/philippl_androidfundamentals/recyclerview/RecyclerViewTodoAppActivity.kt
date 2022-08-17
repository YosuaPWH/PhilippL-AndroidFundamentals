package com.kotlin.philippl_androidfundamentals.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.philippl_androidfundamentals.Todo
import com.kotlin.philippl_androidfundamentals.databinding.ActivityRecyclerViewTodoAppBinding

class RecyclerViewTodoAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewTodoAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewTodoAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Recycler View (Todo App)"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val todoList = mutableListOf(
            Todo("Android Fundamentals", true),
            Todo("Jetpack Compose", false),
            Todo("Coding 10 Hours every day", false)
        )

        val adapter = RecyclerViewTodoAppAdapter(todoList)
        binding.recyclerTodo.adapter = adapter
        binding.recyclerTodo.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val titleTodo = binding.inputTodo.text.toString()
            val todo = Todo(titleTodo, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}