package com.wenbin.publisher.hmoepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wenbin.publisher.databinding.FragmentHomepageBinding

class HomePageFragment : Fragment() {
    private lateinit var binding : FragmentHomepageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater)

        return binding.root
    }
}