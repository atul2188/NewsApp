package com.example.mynewsapp.domain.usecases.news

import com.example.mynewsapp.domain.model.Article
import com.example.mynewsapp.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article){
        newsRepository.upsertArticle(article)
    }
}