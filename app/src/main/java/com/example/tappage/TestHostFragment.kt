package com.example.tappage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tappage.databinding.FragmentTestHostBinding
import com.google.android.material.tabs.TabLayoutMediator


//在Host裡面做範例中用Activity做到的事情
class TestHostFragment : Fragment() {
    private lateinit var binding: FragmentTestHostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: TestHostViewModel by viewModels()
        binding = FragmentTestHostBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        // 設定lifecycleOwner方能監控LiveData資料變化
        binding.lifecycleOwner = this
        handleViews()
        return binding.root
    }

    //將"頁籤資訊"與執行面寫在這個方法之中
    private fun handleViews() {
        //將Tab要顯示的頁面資訊皆儲存在pages之中
        val pages = listOf(
            Page(
                //ContextCompat是獲取資源的方法，像我的Page需要的是Drawable格式但我手上只叫得到drawableid，就用這個方法
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_launcher_background)!!,
                ContextCompat.getColor(requireContext(), R.color.teal_700),
                PostFragment()
            ),
            Page(
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_launcher_background)!!,
                ContextCompat.getColor(requireContext(), R.color.purple_500),
                CommentFragment()
            ),
            Page(
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_launcher_background)!!,
                ContextCompat.getColor(requireContext(), R.color.white),
                PathFragment()
            ),
        )
        with(binding) {
            viewPager2.adapter = MyFragmentStateAdapter(this@TestHostFragment, pages)
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                // 設定tab標題文字
                tab.icon = pages[position].title
                tab.view.setBackgroundColor(pages[position].color)
            }.attach()
        }
    }

    class MyFragmentStateAdapter(activity: TestHostFragment, private var pages: List<Page>) :
        FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return pages.size
        }

        override fun createFragment(position: Int): Fragment {
            return pages[position].fragment
        }
    }
}