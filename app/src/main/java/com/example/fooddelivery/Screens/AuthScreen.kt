package com.example.fooddelivery.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R

@Composable
fun AuthScreen() {
    var selectedTab by remember {
        mutableStateOf(0)
    }

    // titles for the two tabs
    val tabs = listOf("Sign In", "Sign Up")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // center elements horizontally
        verticalArrangement = Arrangement.Top // align items at the top
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // Image at the top
        Image(
            painter = painterResource(id = R.drawable.food_delivery),
            contentDescription = "top image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
                .clip(CircleShape)
                .align(Alignment.Start)// making the image circular
        )

        Spacer(modifier = Modifier.height(24.dp))

        // tab row implementation
        TabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth(),
        ) {

            tabs.forEachIndexed { index, title ->

                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )

            }
        }

    }

    Spacer(modifier = Modifier.height(24.dp))

    // display the form
    when (selectedTab) {
        0 -> SignInForm()
        1 -> SignUpForm()
    }








}

@Composable
fun SignInForm() {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var rememberMe by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Email
        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // password
        OutlinedTextField(
            value = password, onValueChange = { password = it },
            label = { Text(text = "Enter Pass") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // "Remember me" checkbox
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it }
            )
            Text(text = "Remember me")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // login button
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        //sign in with other
        Text(text = "Or")

        Spacer(modifier = Modifier.height(8.dp))

        SocialsSignInButtons()
    }
}

@Composable
fun SignUpForm() {
    var fullName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //full name input
        OutlinedTextField(
            value = fullName, onValueChange = { fullName = it },
            label = { Text(text = "Full Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // email
        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "Email Input") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password, onValueChange = { password = it },
            label = { Text(text = "Create Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        // Sign Up with other buttons

        Text(text = "Or")
        Spacer(modifier = Modifier.height(8.dp))
        SocialsSignInButtons()
    }

}

@Composable
fun SocialsSignInButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            // Google icon
            Icon(painter = painterResource(id = R.drawable.google), contentDescription = "Google")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen()
}