package com.nqh.instagram.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nqh.instagram.Fragments.SettingFragment
import com.nqh.instagram.Fragments.AddFragment
import com.nqh.instagram.Fragments.HomeFragment
import com.nqh.instagram.Fragments.ReelsFragment
import com.nqh.instagram.Fragments.SearchFragment

class BottomNaviMainAdapter(
    private val fm : FragmentManager, private val count : Int
) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return count
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            1 -> SearchFragment()
            2 -> AddFragment()
            3 -> ReelsFragment()
            4 -> SettingFragment()
            else -> HomeFragment()
        }
    }

}