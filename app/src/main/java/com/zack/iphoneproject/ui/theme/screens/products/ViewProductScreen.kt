package com.zack.iphoneproject.ui.theme.screens.products




import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
//import com.example.morningmvvm.data.ProductViewModel
//import com.example.morningmvvm.models.Product
//import com.example.morningmvvm.navigation.ROUTE_UPDATE_PRODUCT
import com.zack.iphoneproject.data.ProductViewModel
import com.zack.iphoneproject.models.Tasks
import com.zack.iphoneproject.navigation.ROUTE_UPDATE_TASK


@Composable
fun ViewTasksScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current
        val productRepository = ProductViewModel.ProductViewModel(navController, context)
        val emptyProductState = remember { mutableStateOf(Tasks("","","","","","","")) }
        val emptyProductsListState = remember { mutableStateListOf<Tasks>() }

        val products = productRepository.viewProducts(emptyProductState, emptyProductsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All tasks",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(products){
                    ProductItem(
                        title = it.title,
                        description = it.description,
                        completed = it.completed,
                        duedate = it.duedate,
                        priority = it.priority,
                        category = it.category,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository
                    )
                }
            }
        }
    }

}



@Composable
fun ProductItem(
    title:String, description:String, completed:String, duedate:String,
    priority:String, category:String,id:String,
    navController:NavHostController, productRepository: ProductViewModel.ProductViewModel
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = title)
        Text(text = description)
        Text(text = completed)
        Text(text = duedate)
        Text(text = priority)
        Text(text = category)
        Button(onClick = {
            productRepository.deleteProduct(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_TASK+"/$id")
        }) {
            Text(text = "Update")
        }
    }

}

@Preview
@Composable
fun view() {
    ViewTasksScreen(rememberNavController())

}





