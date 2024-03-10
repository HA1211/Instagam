package com.nqh.instagram.FireBase

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.nqh.instagram.Activity.LoginActivity
import com.nqh.instagram.Activity.MainActivity
import com.nqh.instagram.Activity.SignUpActivity
import com.nqh.instagram.model.User

class FirestoreClass {
    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerUser(activity: SignUpActivity, userInfo: User){
        mFireStore.collection("UserList")
            .document(getCurrentId())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.registerAccountSuccess()
        }.addOnFailureListener {
                    e ->
                Log.e("log hiep", "Error")
        }
    }

    fun signInUser(activity: Activity){
        mFireStore.collection("UserList")
            .document(getCurrentId())
            .get()
            .addOnSuccessListener { document ->
                val loggedInUser = document.toObject(User::class.java)!!
                when(activity){
                    is LoginActivity ->{
                        activity.signInSuccess(loggedInUser)
                    }

                }
            }.addOnFailureListener {
                    e ->
                Log.e("tag hiep", "Error")
            }
    }

    fun getCurrentId(): String{
        var currentUser = FirebaseAuth.getInstance().currentUser
        var currentUserId = ""
        if(currentUser != null){
            currentUserId = currentUser.uid
        }

        return currentUserId
    }
}