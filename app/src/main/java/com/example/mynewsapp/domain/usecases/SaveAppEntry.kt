package com.example.mynewsapp.domain.usecases

import com.example.mynewsapp.domain.repository.LocalUserRepository

class SaveAppEntry(
    private val localUserRepository : LocalUserRepository
) {
    suspend operator fun invoke(){
        localUserRepository.saveAppEntry()
    }
}