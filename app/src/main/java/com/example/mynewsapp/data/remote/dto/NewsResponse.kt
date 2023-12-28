package com.example.mynewsapp.data.remote.dto

import com.example.mynewsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)