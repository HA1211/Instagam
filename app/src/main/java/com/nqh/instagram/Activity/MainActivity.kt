package com.nqh.instagram.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.nqh.instagram.Adapters.BottomNaviMainAdapter
import com.nqh.instagram.R
import com.nqh.instagram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavi.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.search -> binding.vpgMain.currentItem = 1
                R.id.add -> binding.vpgMain.currentItem = 2
                R.id.reels -> binding.vpgMain.currentItem = 3
                R.id.setting -> binding.vpgMain.currentItem = 4
                else -> binding.vpgMain.currentItem = 0
            }
            true
        }

        val adapter = BottomNaviMainAdapter(supportFragmentManager, 5)

        binding.vpgMain.adapter = adapter

        binding.vpgMain.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    1 -> {
                        binding.bottomNavi.menu.findItem(R.id.search).isChecked = true
                    }
                    2 -> {
                        binding.bottomNavi.menu.findItem(R.id.add).isChecked = true
                    }
                    3 -> {
                        binding.bottomNavi.menu.findItem(R.id.reels).isChecked = true
                    }
                    4 -> {
                        binding.bottomNavi.menu.findItem(R.id.setting).isChecked = true
                    }
                    else -> {
                        binding.bottomNavi.menu.findItem(R.id.home).isChecked = true
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }
}