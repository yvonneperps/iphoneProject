package com.zack.iphoneproject.ui.theme.screens.products


import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
//import com.example.morningmvvm.data.ProductViewModel
//import com.example.morningmvvm.models.Product
//import com.example.morningmvvm.navigation.ROUTE_VIEW_PRODUCT
//import com.example.firebaseauth.data.productviewmodel
//import com.example.firebaseauth.models.Product
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.zack.iphoneproject.data.ProductViewModel
import com.zack.iphoneproject.models.Tasks
import com.zack.iphoneproject.navigation.ROUTE_VIEW_TASK


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateProductsScreen(navController: NavHostController,id:String) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var completed by remember { mutableStateOf("") }
        var duedate by remember { mutableStateOf("") }
        var priority by remember { mutableStateOf("") }
        var category by remember { mutableStateOf("") }

        var currentDataRef = FirebaseDatabase.getInstance().getReference()
            .child("Tasks/$id")
        currentDataRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var product = snapshot.getValue(Tasks::class.java)
                title = product!!.title
                description = product!!.description
                completed = product!!.completed
                duedate = product!!.duedate
                priority = product!!.priority
                category = product!!.category
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        Text(
            text = "Add task",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var productTitle by remember { mutableStateOf(TextFieldValue(title)) }
        var productDescription by remember { mutableStateOf(TextFieldValue(description)) }
        var productCompleted by remember { mutableStateOf(TextFieldValue(completed)) }
        var productDueDate by remember { mutableStateOf(TextFieldValue(duedate)) }
        var productPriority by remember { mutableStateOf(TextFieldValue(priority)) }
        var productCategory by remember { mutableStateOf(TextFieldValue(category)) }

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
            label = { Text(text = "Description *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productCompleted,
            onValueChange = { productCompleted = it },
            label = { Text(text = " Completed*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            value = productDueDate,
            onValueChange = { productDueDate = it },
            label = { Text(text = " DueDate*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            value = productPriority,
            onValueChange = { productPriority = it },
            label = { Text(text = " Priority*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            value = productCategory,
            onValueChange = { productCategory = it },
            label = { Text(text = " Category*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //-----------WRITE THE UPDATE LOGIC HERE---------------//
            var productRepository = ProductViewModel.ProductViewModel(navController, context)
            productRepository.updateProduct(productTitle.text.trim(),productDescription.text.trim(),
                productCompleted.text.trim(),productDueDate.text.trim(),productPriority.text.trim(),
                productCategory.text.trim(),id)
            navController.navigate(ROUTE_VIEW_TASK)

        }) {
            Text(text = "Update")
        }

    }
}

@Preview
@Composable
fun update() {
    UpdateProductsScreen(rememberNavController(), id = "")
}