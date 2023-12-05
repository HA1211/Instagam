package com.nqh.instagram.Activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.nqh.instagram.Adapters.BottomNaviMainAdapter
import com.nqh.instagram.Fragment.AddFragment
import com.nqh.instagram.Fragment.HomeFragment
import com.nqh.instagram.Fragment.ReelsFragment
import com.nqh.instagram.Fragment.SearchFragment
import com.nqh.instagram.Fragment.SettingFragment
import com.nqh.instagram.R
import com.nqh.instagram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.search -> {
                    replaceFragment(SearchFragment())
                }
                R.id.add -> {
                    replaceFragment(AddFragment())
                }
                R.id.reels -> {
                    replaceFragment(ReelsFragment())
                }
                R.id.setting -> {
                    replaceFragment(SettingFragment())
                }
                else -> {
                    replaceFragment(HomeFragment())
                }
            }
            true
        }

        /*val adapter = BottomNaviMainAdapter(supportFragmentManager, 5)

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
        })*/
    }
    fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout_main, fragment)
        fragmentTransaction.commit()
    }
}