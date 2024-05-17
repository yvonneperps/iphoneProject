package com.zack.iphoneproject.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zack.iphoneproject.navigation.ROUTE_ADD_TASK
import com.zack.iphoneproject.navigation.ROUTE_VIEW_TASK

//import com.zack.iphoneproject.navigation.ROUTE_ADD_PRODUCT
//import com.zack.iphoneproject.navigation.ROUTE_VIEW_PRODUCT


@Composable
fun HomeScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context= LocalContext.current
        //  var productdata=productviewmodel(navController,context)

        Text(text = "Welcome to Home page",
            color = Color.Cyan,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_ADD_TASK)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "Add Task")
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_TASK)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "View Task")
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}

//@Composable
//fun HomeScreen(navController: NavController){
//    Column (
//        modifier = Modifier.padding(20.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        Text(text = "This is a home screen")
//        Spacer(modifier = Modifier.height(10.dp))
//        Button(onClick = { /*TODO*/ }) {
//            Text(text = "Products")
//        }
//    }
//}
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun HomeScreenPreview(){
//    HomeScreen(rememberNavController())
//}