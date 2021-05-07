package com.wenbin.publisher.publisharticle

import android.content.ContentValues.TAG
import android.provider.SyncStateContract.Helpers.update
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.happybirthday.data.Information
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class PublishArticleViewModel : ViewModel() {
    var db = FirebaseFirestore.getInstance()

    var title : String? = null
    var category: String? = null
    var content : String? = null




    fun addData() {
        var newTitle = title
        var newCategory = category
        var newContent = content
        val timestamp = Timestamp(System.currentTimeMillis()).toString()


        // new document
        val data = Information(newTitle, newCategory, newContent,
            timestamp)
        db.collection("articles")
            .add(data)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }






        //新增資料到好友名單
//        val washingtonRef = db.collection("articles").document("data")

        //Post Articles
//        fun postArticles () {
//            washingtonRef.
//            update("title", FieldValue.arrayUnion(newTitle),("category") )

//            washingtonRef.
//            update("category", FieldValue.arrayUnion(newCategory))
//            washingtonRef.
//            update("content", FieldValue.arrayUnion(newContent))
//            washingtonRef.
//            update("timestamp", FieldValue.arrayUnion(timestamp))
//        }

    }
}