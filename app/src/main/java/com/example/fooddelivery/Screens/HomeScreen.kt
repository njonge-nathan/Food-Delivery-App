package com.example.fooddelivery.Screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController) {
    Text(text = "Home Screen")
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){

    val navController = rememberNavController()
    HomeScreen(navController)
}