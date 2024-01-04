package com.example.mynewsapp.presentation.details

import com.example.mynewsapp.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    data object RemoveSideeffect : DetailsEvent()
}