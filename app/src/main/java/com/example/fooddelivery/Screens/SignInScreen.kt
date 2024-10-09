package com.example.fooddelivery.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SignInScreen(navController: NavHostController) {

    var sign_email by remember {
        mutableStateOf("")
    }

    var sign_password by remember {
        mutableStateOf("")
    }

    var rememberMe by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            placeholder = { "E-mail Address" },
            label = { "Email" },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
            },
            value = sign_email,
            onValueChange = { sign_email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            placeholder = { "Enter Password" },
            label = { "Password" },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Lock, contentDescription = "Password")
            },
            value = sign_password,
            onValueChange = { sign_password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)

        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it },
                modifier = Modifier.padding(start = 10.dp)
            )
            Text(text = "Remember Me")

            Spacer(modifier = Modifier.width(100.dp))

            ForgotPasswordText {

            }
        }

        OutlinedButton(
            onClick = {
                 navController.navigate("home_screen")
            },
            modifier = Modifier.padding(all = 20.dp)

        ) {
            Text(text = "Login")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )

            Text(
                text = "Or",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )
        }
    }
}

@Composable
fun ForgotPasswordText(onClick: () -> Unit) {
    Text(
        text = "Forgot Password?",
        modifier = Modifier
            .clickable(onClick = onClick)
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignInScreenPreview() {

    val navController = rememberNavController()
    SignInScreen(navController)
}
