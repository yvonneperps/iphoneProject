package com.zack.iphoneproject.ui.theme.screens.about

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zack.iphoneproject.navigation.ROUTE_HOME

@Composable
fun AboutScreen(navController: NavController){
    Column (horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "ABOUT SCREEN")
        }
        Button(onClick = {navController.navigate(ROUTE_HOME)},
            colors = ButtonDefaults.buttonColors(Color.Red)) {
            Text(text = "To HOME Screen")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AboutScreenPreview(){
//    LoginScreen()
}


//@Composable
//fun AboutScreen(navController: NavController){
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "This is about screen")
//        Spacer(modifier = Modifier.height(10.dp))
//        Button(onClick = {
//            navController.navigate(ROUTE_HOME)
//        }) {
//            Text(text = "Go to Home Screen")
//        }
//    }
//}
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun AboutScreenPreview(){
//    AboutScreen(rememberNavController())
//}