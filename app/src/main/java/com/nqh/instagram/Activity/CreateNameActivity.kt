package com.nqh.instagram.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nqh.instagram.Adapters.BottomNaviSettingAdapter
import com.nqh.instagram.databinding.ActivityCreateNameBinding

class CreateNameActivity : AppCompatActivity() {

    lateinit var binding: ActivityCreateNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

        binding.next.setOnClickListener {
            startActivity(Intent(this@CreateNameActivity, CreatePasswordActivity::class.java))
        }
    }
}