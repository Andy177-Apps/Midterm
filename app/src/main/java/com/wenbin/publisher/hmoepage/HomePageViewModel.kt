package com.wenbin.publisher.hmoepage

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.wenbin.publisher.data.Information

class HomePageViewModel : ViewModel() {

    var db = FirebaseFirestore.getInstance()


    private val _informations = MutableLiveData<List<Information>>()

    val informations: LiveData<List<Information>>
        get() = _informations

    private val _showPuhlishment = MutableLiveData<List<Information>>()

    val showPuhlishment: LiveData<List<Information>>
        get() = _showPuhlishment



    /**
     * For catch data
     */
    private val citiesRef = db.collection("articles")
    private val list = citiesRef.orderBy("createdTime", Query.Direction.DESCENDING)
    var defaultData = mutableListOf<Information>()
    var mock = mutableListOf<Information>()

    private fun getData() {
        Log.d("newway", "inti mock = $mock")

        db.collection("articles")
            .orderBy("createdTime", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("newway", "${document.id} => ${document.data}")
                    mock.add(Information(title = document.data["title"].toString(),
                    category = document.data["category"].toString(),
                    content = document.data["content"].toString(),
                    createdTime = document.data["createdTime"].toString()))
                    Log.d("newway", "mock = $mock")
                    break
                }
                _informations.value = mock
                Log.d("newway", "finalmock = $mock")
                Log.d("newway", "_informations.value = ${_informations.value}")

            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }

    }

//    private fun getData() {
//        defaultData.run {
//            add(Information(title = list["title"],
//                id = "133546456",
//                email = "snfsii@gmail.com"
//            ))
//        }
//    }
//    init {
//        getData()
//    }


    /**
     * Observe data instantly
     */
    val personal =
        db.collection("articles")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w("TAG", "listen:error", e)
                    return@addSnapshotListener
                }

                for (dc in snapshots!!.documentChanges) {
                    when (dc.type) {
                        DocumentChange.Type.ADDED -> {Log.d(
                            "TAG",
                            "New Invitation Card: ${dc.document.data}"
                        )
                            var mock123 = dc.document.data
                            Log.d("TAG", "mock = $mock123")
                            getData()
                        }
                        DocumentChange.Type.MODIFIED -> {
                            Log.d(
                                "TAG",
                                "Changed Data: ${dc.document.data}"
                            )
//                            var mock = dc.document.data
//                            Log.d("TAG", "mock = $mock")
//                            defaultData.run {
//                                add(Information(title = mock["title"].toString(),
//                                    category = mock["category"].toString(),
//                                    content = mock["category"].toString(),
//                                    time = mock["timestamp"].toString()
//                                ))
//                            }
//                    val information = Information(
//                            name = mock["name"].toString(),
//                            id = mock["id"].toString(),
//                            email = mock["email"].toString()
//                    )
//                    Log.d("TAG", "information = $information")
//                            _informations.value = defaultData

//                            Log.d("TAG", "_informations.value = ${_informations.value}")

                        }
                        DocumentChange.Type.REMOVED -> Log.d(
                            "TAG",
                            "Removed Invitation Card: ${dc.document.data}"
                        )
                    }
                }
            }


    /**
     * For navigate to Publisher Dialog
     */
    // Handle navigation to OrderFragment
    private val _navigateToPublisher = MutableLiveData<Boolean>()

    val navigateToPublisher: LiveData<Boolean>
        get() = _navigateToPublisher

    fun navigateToPublisher() {
        _navigateToPublisher.value = true
    }

    fun onPublisherNavigated() {
        _navigateToPublisher.value = null
    }
}