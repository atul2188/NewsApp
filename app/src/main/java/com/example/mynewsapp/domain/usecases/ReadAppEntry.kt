package com.example.mynewsapp.domain.usecases

import com.example.mynewsapp.domain.repository.LocalUserRepository
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserRepository: LocalUserRepository
) {
    public operator fun invoke() : Flow<Boolean>{
        return localUserRepository.readAppEntry()
    }
}