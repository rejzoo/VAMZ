package com.example.semstralka_vamz_foltan

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun VyberTemy(navController: NavController) {
    val topics = listOf(
        "Algebra", "Biológia", "Chémia", "Dejepis", "Fyzika",
        "Geografia", "Informatika", "Literatúra", "Matematika", "Slovenský jazyk"
    ).sorted()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(topics) { topic ->
                TopicItem(topic) {
                    navController.navigate("tema/$topic")
                }
            }
        }
    }
}


@Composable
fun TopicItem(topic: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray)
            .padding(16.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(text = topic, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}
