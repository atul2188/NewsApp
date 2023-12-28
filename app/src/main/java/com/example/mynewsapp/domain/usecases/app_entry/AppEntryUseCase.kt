package com.example.mynewsapp.domain.usecases.app_entry

data class AppEntryUseCase(
    val readAppEntryUseCase: ReadAppEntryUseCase,
    val saveAppEntryUseCase: SaveAppEntryUseCase
)
