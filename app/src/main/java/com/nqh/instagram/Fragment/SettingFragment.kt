package com.nqh.instagram.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
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
        replaceFragment(SquareFragment())

        binding.bottomNaviSetting.setOnItemSelectedListener {
            when (it.itemId){
                R.id.picture -> {
                    replaceFragment(PictureFragment())
                }
                R.id.square -> {
                    replaceFragment(SquareFragment())
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container_setting, fragment)
        fragmentTransaction.commit()
    }

}