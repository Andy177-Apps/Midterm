package com.example.happybirthday.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Information (
//        val inviteID : List<String>,
        val title : String?,
//        val friendList : List<String>,
        val category : String? = "id",
        val content : String? = "email",
        val time : String ="05.04"
        ): Parcelable