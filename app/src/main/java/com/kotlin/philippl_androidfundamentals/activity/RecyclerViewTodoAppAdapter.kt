package com.kotlin.philippl_androidfundamentals.activity

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.philippl_androidfundamentals.Todo
import com.kotlin.philippl_androidfundamentals.databinding.LayoutItemTodoBinding

class RecyclerViewTodoAppAdapter(
    var todos: List<Todo>
) : RecyclerView.Adapter<RecyclerViewTodoAppAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: LayoutItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LayoutItemTodoBinding.inflate(layoutInflater, parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            tvTodoTitle.text = todos[position].title
            cbChecked.isChecked = todos[position].isChecked
            strikeThrough(tvTodoTitle, todos[position].isChecked)

            cbChecked.setOnCheckedChangeListener { _, check ->
                strikeThrough(tvTodoTitle, check)
            }
        }
    }

    private fun strikeThrough(tvTodoTitle: TextView, checked: Boolean) {
        if (checked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}