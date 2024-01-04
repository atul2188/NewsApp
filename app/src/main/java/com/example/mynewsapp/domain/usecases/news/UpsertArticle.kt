package com.example.mynewsapp.domain.usecases.news

import com.example.mynewsapp.data.remote.local.NewsDao
import com.example.mynewsapp.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        newsDao.upsert(article)
    }
}