package com.example.semstralka_vamz_foltan


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.semstralka_vamz_foltan.ui.theme.DataTema




@Composable
fun VyberTemy(navController: NavController) {
    val topics = listOf(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.matika),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.7f))
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp, bottom = 50.dp, start = 16.dp , end = 16.dp),
            ) {
                items(topics) { topic ->
                    TopicItem(topic) {
                        navController.navigate(topic.toString())
                    }
                }
            }

        }
    }
}


@Composable
fun TopicItem(topicId: Int, onClick: () -> Unit) {
    val name = DataTema(topicId, LocalContext.current).topicName
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

            .background(Color.White.copy(alpha = 0.9f))
            .clickable(onClick = onClick)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
    }
}



