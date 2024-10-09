package com.example.fooddelivery.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import com.example.fooddelivery.R

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.splash),
            contentDescription = "Intro_screen_image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
            )
        
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)))//overlay
        
        // content over the image
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Yummy",
                fontSize = 20.sp,
                color = Color.White)
            
            Spacer(modifier = Modifier.height(10.dp))
            
            Text(text = "Tasty meals at your service ",
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 24.dp))
            
            // button
            OutlinedButton(onClick = {
                navController.navigate("intro_screen")
            }) {
                Text(text = "Get Started",
                    color = Color.White)
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview(){

//    val navController = TestNavHostController(LocalContext.current)

    /*  used in the preview to simulate a NavHostController
        without needing a full navigation setup.
        It is lightweight and works well in previews
        where you don’t need actual navigation logic.
    *  */
    val navController = rememberNavController()

    SplashScreen(navController)
}
