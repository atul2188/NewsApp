package com.example.mynewsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.mynewsapp.domain.usecases.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
): ViewModel() {
    val news = newsUseCase.getNews(
        sources = listOf("The Times of India","The Hindu","NDTV News", "India Today")
    ).cachedIn(viewModelScope)
}