package com.zack.iphoneproject.ui.theme.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zack.iphoneproject.R
import com.zack.iphoneproject.navigation.ROUTE_LOGIN
import com.zack.iphoneproject.navigation.ROUTE_REGISTER

@Composable
fun OnboardingScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Welcome to Task Management App!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 8.dp)
                .verticalScroll(rememberScrollState())
        )
//        Image(
//            painter = painterResource(id = R.drawable.perps),
//            contentDescription = "Adding Task Walkthrough",
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Effortlessly manage your to-dos with these features:",
            modifier = Modifier.fillMaxWidth()
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                Icons.Outlined.Add, contentDescription = "Add Tasks"
            )
            Text(
                text = "Create and manage tasks",
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(Icons.Outlined.CheckCircle, contentDescription = "Set Due Dates")
            Text(
                text = "Set deadlines and reminders",
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(Icons.Outlined.AccountCircle, contentDescription = "Priorities")
            Text(
                text = "Prioritize tasks for better focus",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Text(
            text = "Adding a task is easy!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        Button(onClick = {
            navController.navigate(ROUTE_REGISTER)
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Get Started")
        }

        Text(
            text = "Enter your task details and click 'Save'.",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

    }
}

@Preview
@Composable
fun OnboardingScreenPreview(){
    OnboardingScreen(rememberNavController())
}
