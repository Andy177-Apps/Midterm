package com.wenbin.publisher.publisharticle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.wenbin.publisher.R
import com.wenbin.publisher.databinding.DialogPublisharticleBinding
import com.wenbin.publisher.databinding.FragmentHomepageBinding

class PublishArticleDialog : DialogFragment() {

    private lateinit var binding: DialogPublisharticleBinding
    val viewModel : PublishArticleViewModel  by lazy {
        ViewModelProvider(this).get(PublishArticleViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogPublisharticleBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.buttonPost.setOnClickListener {
            binding.textViewTitle.text = viewModel.title
        }
        return binding.root
    }
}