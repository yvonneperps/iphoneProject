package com.zack.iphoneproject.ui.theme.screens.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zack.iphoneproject.R

@Composable
fun GalleryScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is gallery screen")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Go to Profile Screen")
        }
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GalleryScreenPreview(){
    GalleryScreen()
}