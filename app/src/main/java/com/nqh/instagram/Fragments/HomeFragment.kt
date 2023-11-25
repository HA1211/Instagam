package com.nqh.instagram.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nqh.instagram.Adapters.PostAdapter
import com.nqh.instagram.R
import com.nqh.instagram.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listString = listOf<String>(
            "Hiep 1",
            "Hiep 2",
            "Hiep 3",
            "Hiep 4",
            "Hiep 5",
            "Hiep 6",
            "Hiep 7"
        )
        val adapter = PostAdapter(listString)
        binding.rcyHome.adapter = adapter
    }

}