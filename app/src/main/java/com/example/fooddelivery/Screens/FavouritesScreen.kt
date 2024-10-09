package com.example.fooddelivery.Screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun FavouritesScreen(navController: NavHostController) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavouritesScreenPreview(){

    val navController = rememberNavController()
    FavouritesScreen(navController)
}