package com.nqh.instagram.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.nqh.instagram.model.AccountModel
import com.nqh.instagram.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.back.setOnClickListener {
            logIn()
        }

        binding.login.setOnClickListener {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }

        binding.forgot.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }

        binding.newacc.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CreateNameActivity::class.java))
        }
    }


    val mDatabase = FirebaseDatabase.getInstance().getReference("root")
    fun logIn(){
        addNewAccount(AccountModel("1234567", "hiep", "hiep", "12"))
    }

    private fun addNewAccount(account: AccountModel) {
        val mDatabase = FirebaseDatabase.getInstance().getReference("root")
        Toast.makeText(this,"add", Toast.LENGTH_SHORT).show()
        mDatabase.child("account").child(account.account_id).setValue(account).addOnFailureListener {
            Toast.makeText(this,"fail", Toast.LENGTH_SHORT).show()
        }.addOnSuccessListener {
            Toast.makeText(this,"ok", Toast.LENGTH_SHORT).show()

        }
    }
}