package com.example.mynewsapp.di

import android.app.Application
import com.example.mynewsapp.data.repository.LocalUserRepositoryImpl
import com.example.mynewsapp.domain.repository.LocalUserRepository
import com.example.mynewsapp.domain.usecases.AppEntryUseCase
import com.example.mynewsapp.domain.usecases.ReadAppEntryUseCase
import com.example.mynewsapp.domain.usecases.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserRepository(
        application: Application
    ) : LocalUserRepository = LocalUserRepositoryImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserRepository: LocalUserRepository
    ) = AppEntryUseCase(
        readAppEntryUseCase = ReadAppEntryUseCase(localUserRepository),
        saveAppEntryUseCase = SaveAppEntryUseCase(localUserRepository)
    )

}