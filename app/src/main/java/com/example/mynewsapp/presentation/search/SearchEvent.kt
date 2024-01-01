package com.example.mynewsapp.presentation.search

sealed class SearchEvent {

    data class UpdateSearchQuery(
        val searchQuery: String
    ): SearchEvent()

    object searchNews : SearchEvent()
}