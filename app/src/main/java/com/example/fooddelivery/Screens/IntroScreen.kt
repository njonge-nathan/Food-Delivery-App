package com.example.fooddelivery.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.R

@Composable
fun IntroScreen(navController: NavHostController) {
    
    Box(modifier = Modifier.fillMaxWidth()){

        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.food)
                    , contentDescription = "top image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(8.dp)
                        .clip(CircleShape) // making the image circular
                        .align(Alignment.TopStart)
                )

            }


            TabScreen(navController)
        }


    }
}

@Composable
fun TabScreen(navController:NavHostController){

    var tabIndex by remember {
        mutableStateOf(0)
    }
    val tabs = listOf("SignIn","SignUp")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)// padding tp add space between the image and TabRow
    ) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title)},
                    selected = tabIndex == index,
                    onClick = {
                        tabIndex = index

                    }
                )
            }
        }
        when(tabIndex){

            0 -> SignInScreen(navController)
            1 -> SignUpScreen(navController, onSignUpComplete = {tabIndex = 0})// after signup complete go back to the sign in tab
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IntroScreenPreview(){

    val navController = rememberNavController()
    IntroScreen(navController)

}