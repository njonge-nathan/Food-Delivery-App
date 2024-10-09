package com.example.fooddelivery.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun MenuScreen(navController: NavHostController) {

}

@Composable
fun MenuScreenPreview(){

    val navController = rememberNavController()
    MenuScreen(navController)
}