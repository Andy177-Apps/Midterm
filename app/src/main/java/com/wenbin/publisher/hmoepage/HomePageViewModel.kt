package com.wenbin.publisher.hmoepage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.happybirthday.data.Information
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class HomePageViewModel : ViewModel() {

    var db = FirebaseFirestore.getInstance()


    private val _informations = MutableLiveData<List<Information>>()

    val informations: LiveData<List<Information>>
        get() = _informations


    /**
     * For catch data
     */
    private val citiesRef = db.collection("articles")
    private val list = citiesRef.orderBy("data", Query.Direction.DESCENDING)
    var defaultData = mutableListOf<Information>()



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
                            var mock = dc.document.data
                            Log.d("TAG", "mock = $mock")
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
                            _informations.value = defaultData
                            Log.d("TAG", "_informations.value = ${_informations.value}")

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