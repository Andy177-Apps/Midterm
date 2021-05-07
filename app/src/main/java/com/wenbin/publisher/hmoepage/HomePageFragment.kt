package com.wenbin.publisher.hmoepage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.wenbin.publisher.NavigationDirections
import com.wenbin.publisher.databinding.FragmentHomepageBinding

class HomePageFragment : Fragment() {
    private lateinit var binding : FragmentHomepageBinding

    private val viewModel : HomePageViewModel by lazy {
        ViewModelProvider(this).get(HomePageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        //navigate to publisher dialog
        viewModel.navigateToPublisher.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().navigate(NavigationDirections.navigateToPublishArticleDialog())
                viewModel.onPublisherNavigated()
            }
        })

        viewModel.informations.observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "infromation in view = ${it}")

        })

        return binding.root
    }
}