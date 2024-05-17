package com.zack.iphoneproject.ui.theme.screens.products


import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zack.iphoneproject.data.ProductViewModel
import com.zack.iphoneproject.navigation.ROUTE_VIEW_TASK
import com.zack.iphoneproject.navigation.ROUTE_VIEW_UPLOAD

//import com.example.morningmvvm.data.ProductViewModel
//import com.example.morningmvvm.navigation.ROUTE_VIEW_PRODUCT
//import com.example.morningmvvm.navigation.ROUTE_VIEW_UPLOAD

//import com.example.firebaseauth.data.productviewmodel
//import com.example.firebaseauth.navigation.ROUTE_VIEW_PRODUCT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        Text(
            text = "Add task",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var productTitle by remember { mutableStateOf(TextFieldValue("")) }
        var productDescription by remember { mutableStateOf(TextFieldValue("")) }
        var productCompleted by remember { mutableStateOf(TextFieldValue("")) }
        var productDueDate by remember { mutableStateOf(TextFieldValue("")) }
        var productPriority by remember { mutableStateOf(TextFieldValue("")) }
        var productCategory by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = productTitle,
            onValueChange = { productTitle = it },
            label = { Text(text = " Title *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productDescription,
            onValueChange = { productDescription = it },
            label = { Text(text = " Description *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productCompleted,
            onValueChange = { productCompleted = it },
            label = { Text(text = " Completed *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productDueDate,
            onValueChange = { productDueDate = it },
            label = { Text(text = " DueDate *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            value = productPriority,
            onValueChange = { productPriority = it },
            label = { Text(text = " Priority *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            value = productCategory,
            onValueChange = { productCategory = it },
            label = { Text(text = " Category *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))



        Button(onClick = {

            val productRepository = ProductViewModel.ProductViewModel(navController, context)
            productRepository.saveProduct(productTitle.text.trim(),productDescription.text.trim(),
                productCompleted.text.trim(),productDueDate.text.trim(),productPriority.text.trim(),productCategory.text.trim())
            navController.navigate(ROUTE_VIEW_TASK)


        }) {
            Text(text = "Save")
        }
        Spacer(modifier = Modifier.height(20.dp))

        //---------------------IMAGE PICKER START-----------------------------------//

        ImagePicker(Modifier,context, navController, productTitle.text.trim(),
            productDescription.text.trim(), productCompleted.text.trim(),productDueDate.text.trim(),
            productPriority.text.trim(),productCategory.text.trim())


    }
}
@Composable
fun ImagePicker(
    modifier: Modifier = Modifier,
    context: Context,
    navController: NavHostController,
    title: String,
    description: String,
    completed: String,
    duedate: String,
    priority: String,
    category: String
) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
//
            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var productRepository = ProductViewModel.ProductViewModel(navController, context)
                productRepository.saveProductWithImage(title, description, completed, duedate, priority, category, imageUri!!)
                navController.navigate(ROUTE_VIEW_UPLOAD)

            }) {
                Text(text = "Upload")
            }
            Button(onClick = {
//                -----------WRITE THE UPLOAD LOGIC HERE---------------//

                navController.navigate(ROUTE_VIEW_UPLOAD)

            }) {
                Text(text = "view uploads")
            }

        }
    }
}
@Preview
@Composable
fun AddProductScreenPreview(){
    AddProductsScreen(rememberNavController())
}
