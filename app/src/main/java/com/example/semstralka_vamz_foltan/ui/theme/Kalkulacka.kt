package com.example.semstralka_vamz_foltan.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.semstralka_vamz_foltan.R

import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

@Composable
fun Kalkulacka() {
    var vysledok by remember { mutableStateOf(0) }
    var textValue by remember { mutableStateOf("") }
    var textValue2 by remember { mutableStateOf("") }
    var textValue3 by remember { mutableStateOf("") }
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
                    .fillMaxWidth()
                    .padding(top = 50.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Column {
                            Text(
                                text = "Binomicke rozdelenie",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(0.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {

                                TextField(
                                    value = textValue,
                                    onValueChange = { textValue = it },
                                    label = { Text("n") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValue2,
                                    onValueChange = { textValue2 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValue3,
                                    onValueChange = { textValue3 = it },
                                    label = { Text("Počet") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )
                            }

                            Row(
                                modifier = Modifier

                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Text(text = "Vysledok:  ${vysledok}",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp))

                                Button(onClick = {
                                    val x = textValue.toIntOrNull() ?: 0
                                    val z = textValue2.toIntOrNull() ?: 0
                                    val y = textValue3.toIntOrNull() ?: 0
                                    vysledok = BinomDist(x, z , y)
                                }) {
                                    Text(text = "Vypocitaj")
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}

fun BinomDist(pocetPokusov: Int, pravdepodobnost: Int , pokus: Int): Int {
    return pocetPokusov + pravdepodobnost + pokus
}
