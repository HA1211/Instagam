package com.nqh.instagram.FireBase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
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
    fun getCurrentId(): String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }
}