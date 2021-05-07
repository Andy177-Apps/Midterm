package com.wenbin.publisher.hmoepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomePageViewModel : ViewModel() {




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