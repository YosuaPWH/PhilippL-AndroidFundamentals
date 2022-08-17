package com.kotlin.philippl_androidfundamentals.viewpager

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kotlin.philippl_androidfundamentals.R
import com.kotlin.philippl_androidfundamentals.activity.ImageActivity
import com.kotlin.philippl_androidfundamentals.databinding.ActivityViewpagerMainBinding

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewpagerMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewpagerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "View Pager"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val images = listOf(
            R.drawable.lotm,
            R.drawable.mounthua,
            R.drawable.nanomachine,
            R.drawable.orv,
            R.drawable.over,
            R.drawable.quest,
            R.drawable.trash,
        )

        val adapterImg = ViewPagerAdapter(images, object : ViewPagerAdapter.MyClickImage {
            override fun click(img: Int) {
                val intent = Intent(this@ViewPagerActivity, ImageActivity::class.java)
                intent.putExtra(ImageActivity.EXTRA_IMAGE, img)
                startActivity(intent)
            }
        })

        binding.viewPager.apply {
            adapter = adapterImg
//            orientation = ViewPager2.ORIENTATION_VERTICAL
//            beginFakeDrag()
//            fakeDragBy(-10f)
        }

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@ViewPagerActivity, "Selected ${tab?.text}", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@ViewPagerActivity, "Unselected ${tab?.text}", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@ViewPagerActivity, "Reselected ${tab?.text}", Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}