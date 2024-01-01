package com.example.mynewsapp.domain.usecases.news

import androidx.paging.PagingData
import com.example.mynewsapp.domain.model.Article
import com.example.mynewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(searchNews: String, sources: List<String>): Flow<PagingData<Article>>{
        return newsRepository.searchNews(searchNews,sources)
    }
}