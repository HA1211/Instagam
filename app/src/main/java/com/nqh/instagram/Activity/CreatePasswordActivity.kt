package com.nqh.instagram.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nqh.instagram.databinding.ActivityCreatePasswordBinding

class CreatePasswordActivity : AppCompatActivity() {

    lateinit var binding: ActivityCreatePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

        binding.next.setOnClickListener {
            startActivity(Intent(this@CreatePasswordActivity, SaveInfoActivity::class.java))
        }

    }
}