package com.example.tappage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.tappage.databinding.FragmentPathBinding
import com.example.tappage.databinding.FragmentPostBinding

class PathFragment : Fragment() {
    private lateinit var binding: FragmentPathBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: PathViewModel by viewModels()
        binding = FragmentPathBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        // 設定lifecycleOwner方能監控LiveData資料變化
        binding.lifecycleOwner = this
        return binding.root
    }
}