package com.nqh.instagram.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nqh.instagram.databinding.ActivitySaveInfoBinding

class SaveInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivitySaveInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaveInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

        binding.notnow.setOnClickListener {
            startActivity(Intent(this@SaveInfoActivity, BirthActivity::class.java))
        }

    }
}