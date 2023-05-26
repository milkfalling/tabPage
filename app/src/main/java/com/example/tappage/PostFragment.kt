package com.example.tappage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tappage.databinding.FragmentPostBinding
import com.example.tappage.databinding.FragmentTestHostBinding

class PostFragment : Fragment() {
    private lateinit var binding: FragmentPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel:PostsViewmodel by viewModels()
        binding = FragmentPostBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        // 設定lifecycleOwner方能監控LiveData資料變化
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            // 使用 GridLayoutManager 设置网格布局，参数中的 spanCount 决定每行显示的列数
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            viewModel?.posts?.observe(viewLifecycleOwner) { posts ->
                recyclerView.adapter = PostAdapter(posts)
            }
        }
    }
}