package com.example.mynewsapp.presentation.bookmark

import com.example.mynewsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)