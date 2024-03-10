package com.nqh.instagram.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.nqh.instagram.FireBase.FirestoreClass
import com.nqh.instagram.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            var currentUserId = FirestoreClass().getCurrentId()
            if(currentUserId.isNotEmpty()){
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }else{
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            }
        }, 500L)
        onBackPressed()
    }

    override fun onBackPressed() {
    }
}