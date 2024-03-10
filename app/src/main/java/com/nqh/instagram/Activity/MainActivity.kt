package com.nqh.instagram.Activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
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
                R.id.menu_search -> {
                    replaceFragment(SearchFragment())
                }
                R.id.menu_add -> {
                    replaceFragment(AddFragment())
                }
                R.id.menu_reels -> {
                    replaceFragment(ReelsFragment())
                }
                R.id.menu_setting -> {
                    replaceFragment(SettingFragment())
                }
                else -> {
                    replaceFragment(HomeFragment())
                }
            }
            true
        }
    }
    fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout_main, fragment)
        fragmentTransaction.commit()
    }


}