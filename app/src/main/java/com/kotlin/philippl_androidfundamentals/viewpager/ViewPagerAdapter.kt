package com.kotlin.philippl_androidfundamentals.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.philippl_androidfundamentals.databinding.ActivityViewpagerItemBinding

class ViewPagerAdapter(private val images: List<Int>, private var listener: MyClickImage) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(val binding: ActivityViewpagerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityViewpagerItemBinding.inflate(layoutInflater, parent, false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.binding.apply {
            imageViewPager.setImageResource(images[position])
            imageViewPager.setOnClickListener {
                listener.click(images[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

    interface MyClickImage {
        fun click(img: Int)
    }

}