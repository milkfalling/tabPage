package com.example.tappage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.tappage.databinding.FragmentTestHostBinding


//在Host裡面做範例中用Activity做到的事情
class TestHostFragment : Fragment() {
    private lateinit var binding:FragmentTestHostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel:TestHostViewModel by viewModels()
        binding = FragmentTestHostBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        // 設定lifecycleOwner方能監控LiveData資料變化
        binding.lifecycleOwner = this
        return binding.root
    }
}