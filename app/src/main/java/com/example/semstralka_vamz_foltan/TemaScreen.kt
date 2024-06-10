package com.example.semstralka_vamz_foltan

import android.content.Context
import android.graphics.Paint.Align
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semstralka_vamz_foltan.ui.theme.DataPriklad
import com.example.semstralka_vamz_foltan.ui.theme.DataTema
import com.example.semstralka_vamz_foltan.ui.theme.Priklad


@Composable
fun TemaScreen(navController: NavController, topic: Int?) {
    val data = DataTema(topic, LocalContext.current)
    val name = data.topicName
    val info = data.topicText
    val priklady = listOf(
        Priklad(priklad = DataPriklad(topic , LocalContext.current )),
        Priklad(priklad = DataPriklad(topic?.plus(1), LocalContext.current )),
        Priklad(priklad = DataPriklad(topic?.plus(2), LocalContext.current )))

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.matika),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.9f
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.7f))
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(15.dp)
            ) {
                Text(
                    text = name,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(10.dp)
            ) {
                Text(
                    text = info,
                    fontSize = 19.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row (modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly)
            {
                Button(onClick = {
                    topic?.let { navController.navigate("priklad/$it")}
                }) {
                    Text(text = "Priklad 1")
                }
                Button(onClick = {
                    topic?.plus(1).let { navController.navigate("priklad/$it")}
                }) {
                    Text(text = "Priklad 2")
                }
                Button(onClick = {
                    topic?.plus(2).let { navController.navigate("priklad/$it")}
                }) {
                    Text(text = "Priklad 3")
                }
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(onClick = {
                    navController.navigate("quiz")
                }) {
                    Text(text = "Quiz")
                }

                Button(onClick = {
                    topic?.let { navController.navigate("kalkulacka/$it") }
                }) {
                    Text(text = "Kalkulačka")
                }
            }
        }
    }
}


