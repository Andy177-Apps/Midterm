package com.wenbin.publisher.publisharticle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.wenbin.publisher.R
import com.wenbin.publisher.databinding.DialogPublisharticleBinding

class PublishArticleDialog : DialogFragment() {

    private lateinit var binding: DialogPublisharticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogPublisharticleBinding.inflate(inflater)

        return binding.root
    }
}