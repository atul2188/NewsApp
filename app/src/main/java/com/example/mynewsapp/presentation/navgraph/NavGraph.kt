package com.example.mynewsapp.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.mynewsapp.presentation.bookmark.BookmarkScreen
import com.example.mynewsapp.presentation.bookmark.BookmarkViewModel
import com.example.mynewsapp.presentation.common.SearchBar
import com.example.mynewsapp.presentation.home.HomeScreen
import com.example.mynewsapp.presentation.home.HomeViewModel
import com.example.mynewsapp.presentation.newsnavigator.NewsNavigator
import com.example.mynewsapp.presentation.onboarding.OnBoardingScreen
import com.example.mynewsapp.presentation.onboarding.OnBoardingViewModel
import com.example.mynewsapp.presentation.search.SearchScreen
import com.example.mynewsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination ){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel : OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(
                route = Route.NewsNavigatorScreen.route
            ){
                NewsNavigator()
            }
        }
    }
}