package com.nqh.instagram.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nqh.instagram.databinding.ActivityBirthBinding

class BirthActivity : AppCompatActivity() {

    lateinit var binding: ActivityBirthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBirthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

        binding.next.setOnClickListener {
            startActivity(Intent(this@BirthActivity, PhoneNumberActivity::class.java))
        }
/*
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            binding.txtContent.text = Html.fromHtml("<p>Tại sao tôi cần cung cấp ngày sinh của mình?</p>", Html.FROM_HTML_MODE_COMPACT)
        else
            binding.txtContent.text = Html.fromHtml("<p>Tại sao tôi cần cung cấp ngày sinh của mình?</p>")*/
    }
}