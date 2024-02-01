package com.nqh.instagram.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.nqh.instagram.Adapters.BottomNaviSettingAdapter
import com.nqh.instagram.R
import com.nqh.instagram.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNaviSetting.setOnNavigationItemSelectedListener {item ->
            when (item.itemId){
                R.id.menu_picture -> binding.vpgSetting.currentItem = 1
                else -> binding.vpgSetting.currentItem = 0
            }
            true
        }

        val adapter = BottomNaviSettingAdapter(requireActivity().supportFragmentManager, 2)

        binding.vpgSetting.adapter = adapter

        binding.vpgSetting.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    1 -> {
                        binding.bottomNaviSetting.menu.findItem(R.id.menu_picture).isChecked = true
                    }
                    else -> {
                        binding.bottomNaviSetting.menu.findItem(R.id.menu_square).isChecked = true
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }
}