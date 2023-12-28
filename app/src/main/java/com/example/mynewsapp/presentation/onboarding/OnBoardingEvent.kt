package com.example.mynewsapp.presentation.onboarding

sealed class OnBoardingEvent {

    data object SaveAppEntry : OnBoardingEvent()
}