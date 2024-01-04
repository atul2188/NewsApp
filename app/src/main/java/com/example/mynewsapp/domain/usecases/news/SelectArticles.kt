package com.example.mynewsapp.domain.usecases.news

import com.example.mynewsapp.data.remote.local.NewsDao
import com.example.mynewsapp.domain.model.Article
import com.example.mynewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {

    operator fun invoke() : Flow<List<Article>>{
        return newsRepository.getArticles()
    }
}