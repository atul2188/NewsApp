package com.example.mynewsapp.domain.usecases.app_entry

import com.example.mynewsapp.domain.repository.LocalUserRepository

class SaveAppEntryUseCase(
    private val localUserRepository : LocalUserRepository
) {
    suspend operator fun invoke(){
        localUserRepository.saveAppEntry()
    }
}