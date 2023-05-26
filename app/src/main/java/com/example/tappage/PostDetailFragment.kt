package com.example.tappage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tappage.databinding.FragmentPostDetailBinding

class PostDetailFragment : Fragment() {
    private lateinit var binding:FragmentPostDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val viewModel: PostViewModel by viewModels()
        binding = FragmentPostDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let { bundle ->
            bundle.getSerializable("post")?.let {
                binding.viewModel?.post?.value = it as Post
            }
        }
    }
}