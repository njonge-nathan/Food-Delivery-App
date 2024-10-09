package com.example.fooddelivery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.Screens.FavouritesScreen
import com.example.fooddelivery.Screens.HomeScreen
import com.example.fooddelivery.Screens.IntroScreen
import com.example.fooddelivery.Screens.MenuScreen
import com.example.fooddelivery.Screens.ProfileScreen
import com.example.fooddelivery.Screens.SignInScreen
import com.example.fooddelivery.Screens.SignUpScreen
import com.example.fooddelivery.Screens.SplashScreen

@Composable
fun Nav(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "get_started") {

        composable(route = "get_started"){
            SplashScreen(navController)
        }
         composable(route = "intro_screen"){
            IntroScreen(navController)
        }
         composable(route = "home_screen"){
            HomeScreen(navController)
        }
         composable(route = "menu_screen"){
            MenuScreen(navController)
        }
        composable(route = "profile_screen"){
            ProfileScreen(navController)
        }
        composable(route = "favourites_screen"){
            FavouritesScreen(navController)
        }
        composable(route = "sign_In_screen") {
            SignInScreen(navController)
        }
        composable(route = "sign_up_screen") {

            // Pass an empty lambda for the onSignUpComplete function
            SignUpScreen(navController, onSignUpComplete = {})
        }



    }
}