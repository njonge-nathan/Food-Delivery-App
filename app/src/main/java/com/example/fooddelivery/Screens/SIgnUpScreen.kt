package com.example.fooddelivery.Screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
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
fun SignUpScreen(navController: NavHostController, onSignUpComplete: () -> Unit) {

    var sign_up_email by remember {
        mutableStateOf("")
    }

    var sign_up_password by remember {
        mutableStateOf("")
    }

    var rememberMe by remember {
        mutableStateOf(false)
    }

    var sign_up_name by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            placeholder = {"Full Name"},
            label = { "full names" },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Face, contentDescription = "Email Icon")
            },
            value = sign_up_name,
            onValueChange = { sign_up_name = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            placeholder = {"E-mail Address"},
            label = { "Email" },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
            },
            value = sign_up_email,
            onValueChange = { sign_up_email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )


        OutlinedTextField(
            placeholder = {"Create Password"},
            label = { "Password"},
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Lock, contentDescription = "Password")
            },
            value = sign_up_password,
            onValueChange = { sign_up_password = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)

        )

        Spacer(modifier = Modifier.height(10.dp))



        OutlinedButton(
            onClick = {
                // call the onSIgnUpComplete function to go back to the signin tab
                      onSignUpComplete()
            },
            modifier = Modifier.padding(all = 20.dp)

        ) {
            Text(text = "Create Account")
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

            Text(text = "Or",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold)

            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignUpScreenPreview() {

    val navController = rememberNavController()

    // Pass an empty lambda for the onSignUpComplete function
    SignUpScreen(navController, onSignUpComplete = {})
}
