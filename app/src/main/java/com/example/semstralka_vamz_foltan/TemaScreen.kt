package com.example.semstralka_vamz_foltan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semstralka_vamz_foltan.ui.theme.DataTema
import com.example.semstralka_vamz_foltan.ui.theme.DataText



@Composable
fun TemaScreen(navController: NavController, topic: Int?) {
    val dataTema = DataTema(topic, LocalContext.current)
    val name = dataTema.topicName
    val list: MutableList<Int> = mutableListOf()
    var podTema = DataText(topic , 1, LocalContext.current)
    var index = 1

    while (podTema.text != "") {
        list.add(index)
        index++
        podTema = DataText(topic , index , LocalContext.current)


    }

    Surface(
        modifier = Modifier.fillMaxSize()
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

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp, bottom = 30.dp)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
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

            }

            items(list.size) { podTema ->
                PodTema(topic, podTema)
            }


            item {
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                )
                {
                    Button(onClick = {
                        topic?.let { navController.navigate("priklad/$it") }
                    }) {
                        Text(text = "Priklad 1")
                    }
                    Button(onClick = {
                        topic?.times(2)?.let { navController.navigate("priklad/$it") }
                    }) {
                        Text(text = "Priklad 2")
                    }
                    Button(onClick = {
                        topic?.times(3)?.let { navController.navigate("priklad/$it") }
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
}

@Composable
fun PodTema(topic: Int?, podTema: Int) {
    val data = DataText(topic, podTema, LocalContext.current)
    if (data.text != "") {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(15.dp)
        ) {
            Text(
                text = data.text,
                fontSize = 15.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
    if (data.idObrazku != 0) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(15.dp)
        ) {

            Image(
                painter = painterResource(id = data.idObrazku),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )


        }
    }

    Spacer(modifier = Modifier.height(10.dp))

}







