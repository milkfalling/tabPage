package com.example.tappage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tappage.databinding.PostItemViewBinding

class PostAdapter(private var posts: List<Post>) : //private var=既是屬性也是參數的傳法
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    fun updatePosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    class PostViewHolder(val itemViewBinding: PostItemViewBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemViewBinding =
            PostItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        itemViewBinding.viewModel = PostViewModel()
        itemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return PostViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        with(holder) {
            itemViewBinding.viewModel?.post?.value = post
            val bundle = Bundle()
            bundle.putSerializable("post", post)
            itemView.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.postDetailFragment,bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }


}