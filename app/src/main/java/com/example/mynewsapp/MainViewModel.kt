package com.example.mynewsapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsapp.domain.usecases.app_entry.AppEntryUseCase
import com.example.mynewsapp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase
): ViewModel() {

    //private mutable backing property
    private val _splashCondition = mutableStateOf(true)
    //public immutable state exposed
    val splashCondition: State<Boolean> = _splashCondition

    private val _startDestination = mutableStateOf(Route.AppStartNavigation.route)
    val startDestination: State<String> = _startDestination

    init {
        appEntryUseCase.readAppEntry().onEach { shouldStartFromHomeScree ->
            if(shouldStartFromHomeScree){
                _startDestination.value = Route.NewsNavigation.route
            }else{
                _startDestination.value = Route.AppStartNavigation.route
            }
            delay(300)
            _splashCondition.value = false
        }.launchIn(viewModelScope)
    }
}