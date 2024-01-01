package com.example.mynewsapp.di

import android.app.Application
import com.example.mynewsapp.data.remote.dto.NewsApi
import com.example.mynewsapp.data.repository.LocalUserRepositoryImpl
import com.example.mynewsapp.data.repository.NewsRepositoryImpl
import com.example.mynewsapp.domain.repository.LocalUserRepository
import com.example.mynewsapp.domain.repository.NewsRepository
import com.example.mynewsapp.domain.usecases.app_entry.AppEntryUseCase
import com.example.mynewsapp.domain.usecases.app_entry.ReadAppEntry
import com.example.mynewsapp.domain.usecases.app_entry.SaveAppEntry
import com.example.mynewsapp.domain.usecases.news.GetNews
import com.example.mynewsapp.domain.usecases.news.NewsUseCase
import com.example.mynewsapp.domain.usecases.news.SearchNews
import com.example.mynewsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
        readAppEntry = ReadAppEntry(localUserRepository),
        saveAppEntry = SaveAppEntry(localUserRepository)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCase(
        newsRepository: NewsRepository
    ) = NewsUseCase(
        getNews = GetNews(newsRepository),
        searchNews = SearchNews(newsRepository)
    )

}