package com.wenbin.publisher.publisharticle

import android.content.ContentValues.TAG
import android.provider.SyncStateContract.Helpers.update
import android.util.Log
import androidx.lifecycle.ViewModel
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
        val articles = FirebaseFirestore.getInstance()
            .collection("articles")
        val document = articles.document()
        val data = hashMapOf(
            "author" to hashMapOf(
                "email" to "wayne@school.appworks.tw",
                "id" to "waynechen323",
                "name" to "AKA小安老師"
            ),
            "title" to newTitle,
            "content" to newContent,
            "createdTime" to Calendar.getInstance().timeInMillis,
            "id" to document.id,
            "category" to newCategory
        )
        document.set(data)
    }


//    fun addData() {
//        var newTitle = title
//        var newCategory = category
//        var newContent = content
//        val timestamp = Timestamp(System.currentTimeMillis()).toString()
//
//        val data = Information(newTitle, newCategory, newContent,
//            timestamp)
//        db.collection("articles")
//            .add(data)
//            .addOnSuccessListener { documentReference ->
//                Log.d(TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
//            }
//            .addOnFailureListener { e ->
//                Log.w(TAG, "Error adding document", e)
//            }
//    }
}