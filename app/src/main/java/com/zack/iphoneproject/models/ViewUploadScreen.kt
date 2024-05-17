package com.zack.iphoneproject.models


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

//import com.example.morningmvvm.data.ProductViewModel
//import com.example.morningmvvm.models.Upload
//import com.example.morningmvvm.navigation.ROUTE_UPDATE_PRODUCT
import com.zack.iphoneproject.data.ProductViewModel
import com.zack.iphoneproject.navigation.ROUTE_UPDATE_TASK


@Composable
fun ViewUploadsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var productRepository = ProductViewModel.ProductViewModel(navController, context)


        val emptyUploadState = remember { mutableStateOf(Upload("","","","","","","")) }
        var emptyUploadsListState = remember { mutableStateListOf<Upload>() }

        var uploads = productRepository.viewUploads(emptyUploadState, emptyUploadsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All uploads",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(uploads){
                    UploadItem(
                        title = it.title,
                        description = it.description,
                        completed = it.completed,
                        duedate =it.duedate,
                        priority = it.priority,
                        category = it.category,
                        imageUrl = it.imageUrl,
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
fun UploadItem(
    title:String, description:String, completed:String, duedate:String,priority:String,category:String,imageUrl:String, id:String,
    navController:NavHostController, productRepository: ProductViewModel.ProductViewModel
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = title)
        Text(text = description)
        Text(text = completed)
        Text(text = duedate)
        Text(text = priority)
        Text(text = category)
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
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
