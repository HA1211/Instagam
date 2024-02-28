package com.nqh.instagram.Activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.nqh.instagram.FireBase.FirestoreClass
import com.nqh.instagram.databinding.ActivityLoginBinding
import com.nqh.instagram.model.User

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        auth = Firebase.auth

        setContentView(binding.root)

        binding.btnForgotPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }

        binding.newacc.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        }
        binding.btnSignIn.setOnClickListener {
            signInUser()
        }
    }

    fun signInSuccess(user: User) {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }

    private fun signInUser(
        email: String = binding.etEmailSignIn.text.toString().trim { it <= ' '},
        password: String = binding.etPasswordSignIn.text.toString().trim { it <= ' '}
    ){
        if(checkEmpty(email, password)){
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){task ->
                if(task.isSuccessful){
                    FirestoreClass().signInUser(this)
                    startActivity(Intent(this, MainActivity::class.java))
                }else {
                    Log.w("hiep", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
        }
    }

    fun checkEmpty(
        email: String, password: String
    ): Boolean{
        return when{
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_LONG).show()
                false
            }
            TextUtils.isEmpty(password) -> {
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_LONG).show()
                false
            }else -> {
                true
            }
        }
    }

}