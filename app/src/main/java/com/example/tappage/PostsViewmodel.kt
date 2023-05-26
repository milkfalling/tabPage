package com.example.tappage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostsViewmodel : ViewModel() {
    // 原始好友列表，除非去遠端更新資料不然不會改變
    private var postList = mutableListOf<Post>()
    // 受監控的LiveData，一旦指派新值就會更新好友列表畫面
    val posts: MutableLiveData<List<Post>> by lazy { MutableLiveData<List<Post>>() }

    //在constuctor之後，但是在呼叫其他函式之前
    init {
        loadPosts()
    }

    /**
     * 如果搜尋條件為空字串，就顯示原始好友列表；否則就顯示搜尋後結果
     * @param newText 欲搜尋的條件字串
     */
//    fun search(newText: String?) {
//        if (newText == null || newText.isEmpty()) {
//            posts.value = postList
//        } else {
//            val searchPostList = mutableListOf<Post>()
//            postList.forEach { post ->
//                if (post.name.contains(newText, true)) {
//                    searchPostList.add(post)
//                }
//            }
//            posts.value = searchPostList
//        }
//    }

    /** 模擬取得遠端資料 */
    private fun loadPosts() {
        val postList = mutableListOf<Post>()
        postList.add(Post(R.drawable.ivy,"好棒好棒好棒好棒好棒好棒"))
        postList.add(Post(R.drawable.mary,"好棒好棒好棒好棒好棒好棒"))
        postList.add(Post(R.drawable.sue,"好棒好棒好棒好棒好棒好棒"))
        postList.add(Post(R.drawable.ivy,"好棒好棒好棒好棒好棒好棒"))
        postList.add(Post(R.drawable.mary,"好棒好棒好棒好棒好棒好棒"))
        postList.add(Post(R.drawable.sue,"好棒好棒好棒好棒好棒好棒"))
        postList.add(Post(R.drawable.ivy,"好棒好棒好棒好棒好棒好棒"))
        postList.add(Post(R.drawable.mary,"好棒好棒好棒好棒好棒好棒"))
        postList.add(Post(R.drawable.sue,"好棒好棒好棒好棒好棒好棒"))
        this.postList = postList
        this.posts.value = this.postList
    }
}