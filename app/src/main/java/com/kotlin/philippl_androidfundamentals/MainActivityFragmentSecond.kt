package com.kotlin.philippl_androidfundamentals

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.philippl_androidfundamentals.activity.*
import com.kotlin.philippl_androidfundamentals.databinding.ActivityMainFragment2Binding
import com.kotlin.philippl_androidfundamentals.fragment.FragmentActivity

class MainActivityFragmentSecond : Fragment() {

    private var _binding: ActivityMainFragment2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityMainFragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFragment.setOnClickListener {
            startActivity(Intent(activity, FragmentActivity::class.java))
        }

        binding.btnRecyclerView.setOnClickListener {
            startActivity(Intent(activity, RecyclerViewTodoAppActivity::class.java))
        }

        binding.btnViewPager.setOnClickListener {
            startActivity(Intent(activity, ViewPagerActivity::class.java))
        }

        binding.btnSlideableMenu.setOnClickListener {
            startActivity(Intent(activity, SlideableMenuActivity::class.java))
        }

        binding.btnSharedPreferences.setOnClickListener {
            startActivity(Intent(activity, SharedPreferencesActivity::class.java))
        }

        binding.btnNotifications.setOnClickListener {
            startActivity(Intent(activity, NotificationActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}