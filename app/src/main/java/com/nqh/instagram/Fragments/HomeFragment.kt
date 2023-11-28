package com.nqh.instagram.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nqh.instagram.Adapters.PostAdapter
import com.nqh.instagram.PostModel
import com.nqh.instagram.R
import com.nqh.instagram.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listString = listOf<PostModel>(
            PostModel("","","Hiep 1", ""),
            PostModel("","","Hiep 2", ""),
            PostModel("","","Hiep 3", ""),
            PostModel("","","Hiep 4", ""),
            PostModel("","","Hiep 5", ""),
            PostModel("","","Hiep 5", ""),
            PostModel("","","Hiep 5", ""),
            PostModel("","","Hiep 5", ""),
            PostModel("","","Hiep 5", ""),
            PostModel("","","Hiep 6", "")
        )
        val adapter = PostAdapter(listString)
        binding.rcyHome.adapter = adapter
    }

}