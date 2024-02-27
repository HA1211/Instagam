package com.nqh.instagram.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.nqh.instagram.FireBase.FirestoreClass
import com.nqh.instagram.R
import com.nqh.instagram.databinding.ActivitySignUpBinding
import com.nqh.instagram.model.User

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            registerAccount()
        }

    }

    fun registerAccountSuccess(){
        Toast.makeText(this,"You have successful with email", Toast.LENGTH_LONG).show()
    }

    fun registerAccount(
        name: String = binding.etName.text.toString().trim{it <= ' '},
        email: String = binding.etEmail.text.toString().trim{it <= ' '},
        password: String = binding.etPassword.text.toString().trim{it <= ' '}
    ){
        if(checkEmpty(name, email, password)){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {task ->
                if(task.isSuccessful){
                    val firebaseUser: FirebaseUser = task.result!!.user!!
                    val registeredEmail = firebaseUser.email!!
                    val user = User(firebaseUser.uid, name, registeredEmail)

                    FirestoreClass().registerUser(this, user)

                    startActivity(Intent(this, MainActivity::class.java))
                }else{
                    Toast.makeText(this,"Fail",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun checkEmpty(name: String, email: String, password: String): Boolean{
        return when{
            TextUtils.isEmpty(name) -> {
                Toast.makeText(this, "Vui long nhap ten", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(email) ->{
                Toast.makeText(this, "Vui long nhap email", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(password) ->{
                Toast.makeText(this, "Vui long nhap mat khau", Toast.LENGTH_SHORT).show()
                false
            }else -> {
                return true
            }
        }
    }


















}