package com.example.tappage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostViewModel : ViewModel() {
        val post:MutableLiveData<Post> by lazy {MutableLiveData<Post>() }
}