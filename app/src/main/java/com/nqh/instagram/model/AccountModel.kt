package com.nqh.instagram.model

import android.os.Parcelable
import com.google.firebase.database.Exclude
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AccountModel(
    val account_id: String,
    val userName: String,
    val password: String,
    val createTime: String
) : Parcelable {

    constructor() : this("", "", "","") {}

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "account_id" to account_id,
            "userName" to userName,
            "password" to password,
            "createTime" to createTime
        )
    }companion object {
        fun toPostModel(jsonData: String): AccountModel? {
            return Gson().fromJson(jsonData, AccountModel::class.java)
        }
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }

}
