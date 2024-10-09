package com.example.fooddelivery.Screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(navController: NavHostController) {

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfileScreenPreview(){

    val navController = rememberNavController()
    ProfileScreen(navController)
}