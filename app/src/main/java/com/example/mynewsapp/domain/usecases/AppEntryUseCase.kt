package com.example.mynewsapp.domain.usecases

data class AppEntryUseCase(
    val readAppEntryUseCase: ReadAppEntryUseCase,
    val saveAppEntryUseCase: SaveAppEntryUseCase
)
