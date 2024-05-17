package com.zack.iphoneproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.afternoonmvvm.ui.theme.screens.login.LoginScreen
import com.example.afternoonmvvm.ui.theme.screens.register.RegisterScreen
import com.zack.iphoneproject.models.ViewUploadsScreen
import com.zack.iphoneproject.ui.theme.screens.about.AboutScreen
import com.zack.iphoneproject.ui.theme.screens.home.HomeScreen
import com.zack.iphoneproject.ui.theme.screens.onboarding.OnboardingScreen
import com.zack.iphoneproject.ui.theme.screens.products.AddProductsScreen
import com.zack.iphoneproject.ui.theme.screens.products.UpdateProductsScreen
import com.zack.iphoneproject.ui.theme.screens.products.ViewTasksScreen

//import com.zack.iphoneproject.ui.theme.screens.login.LoginScreen
//import com.zack.iphoneproject.ui.theme.screens.register.RegisterScreen

@Composable
fun AppNavHost(modifier: Modifier=Modifier,
               navController: NavHostController= rememberNavController(),
               startDestination: String= ROUTE_ONBOARDING){
    NavHost(navController = navController,
        modifier = modifier,
        startDestination = startDestination ){
        composable(ROUTE_ONBOARDING){ OnboardingScreen(navController)}
        composable(ROUTE_REGISTER){ RegisterScreen(navController)}
        composable(ROUTE_LOGIN){ LoginScreen(navController)}
        composable(ROUTE_HOME){ HomeScreen(navController)}
        composable(ROUTE_ADD_TASK){ AddProductsScreen(navController)}
        composable(ROUTE_VIEW_TASK){ ViewTasksScreen(navController)}
        composable(ROUTE_UPDATE_TASK+"/{id}"){
            passedData-> UpdateProductsScreen(
                navController,passedData.arguments?.getString("id")!!
            )
        }
        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadsScreen(navController)
        }

    }

}