package com.nqh.instagram.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nqh.instagram.databinding.ActivityBirthBinding
import com.nqh.instagram.databinding.ActivityPhoneNumberBinding

class PhoneNumberActivity : AppCompatActivity() {

    lateinit var binding: ActivityPhoneNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }
    }
}