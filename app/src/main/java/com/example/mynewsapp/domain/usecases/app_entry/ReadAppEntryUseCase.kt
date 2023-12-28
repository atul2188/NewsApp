package com.example.mynewsapp.domain.usecases.app_entry

import com.example.mynewsapp.domain.repository.LocalUserRepository
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(
    private val localUserRepository: LocalUserRepository
) {
    public operator fun invoke() : Flow<Boolean>{
        return localUserRepository.readAppEntry()
    }
}