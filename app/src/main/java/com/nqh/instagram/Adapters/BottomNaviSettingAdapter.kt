package com.nqh.instagram.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nqh.instagram.Fragment.PictureFragment
import com.nqh.instagram.Fragment.SquareFragment

class BottomNaviSettingAdapter(
    private val fm: FragmentManager, private val count: Int
): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return count
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            1 -> PictureFragment()
            else -> SquareFragment()
        }
    }
}