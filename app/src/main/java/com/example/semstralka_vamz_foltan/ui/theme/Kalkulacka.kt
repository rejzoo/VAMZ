package com.example.semstralka_vamz_foltan.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import kotlin.math.exp

@Composable
fun Kalkulacka() {
    var vysledok by remember { mutableStateOf(0.0) }
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
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Text(
                                    text = "Vysledok:  $vysledok",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val x = textValue.toIntOrNull() ?: 0
                                    val z = textValue2.toDouble()
                                    val y = textValue3.toIntOrNull() ?: 0
                                    vysledok = BinomDist(x, z, y)
                                }) {
                                    Text(text = "Vypocitaj")
                                }
                            }
                        }
                    }
                }

                item {
                    var vysledok1 by remember { mutableStateOf(0.0) }
                    var textValue4 by remember { mutableStateOf("") }
                    var textValue5 by remember { mutableStateOf("") }


                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Column {
                            Text(
                                text = "Geometrické rozdelenie",
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
                                    value = textValue4,
                                    onValueChange = { textValue4 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValue5,
                                    onValueChange = { textValue5 = it },
                                    label = { Text("Počet") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )


                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Text(
                                    text = "Vysledok:  $vysledok1",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val a = textValue4.toDouble()
                                    val b = textValue5.toDouble()

                                    vysledok1 = GeoDist(a, b)
                                }) {
                                    Text(text = "Vypocitaj")
                                }
                            }
                        }
                    }
                }



                item {
                    var vysledok2 by remember { mutableStateOf(0.0) }
                    var textValue6 by remember { mutableStateOf("") }
                    var textValue7 by remember { mutableStateOf("") }
                    var textValue8 by remember { mutableStateOf("") }
                    var textValue9 by remember { mutableStateOf("") }


                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Column {
                            Text(
                                text = "Hypergeometrické rozdelenie",
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
                                    value = textValue6,
                                    onValueChange = { textValue6 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(50.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValue7,
                                    onValueChange = { textValue7 = it },
                                    label = { Text("B") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(50.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValue8,
                                    onValueChange = { textValue8 = it },
                                    label = { Text("C") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(50.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )
                                TextField(
                                    value = textValue9,
                                    onValueChange = { textValue9 = it },
                                    label = { Text("D") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(50.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )


                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Text(
                                    text = "Vysledok:  $vysledok2",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val a = textValue6.toIntOrNull() ?: 0
                                    val b = textValue7.toIntOrNull() ?: 0
                                    val c = textValue8.toIntOrNull() ?: 0
                                    val d = textValue9.toIntOrNull() ?: 0

                                    vysledok2 = HypGeoDist(a, b, c, d)
                                }) {
                                    Text(text = "Vypocitaj")
                                }
                            }
                        }
                    }
                }

                item {
                    var vysledok by remember { mutableStateOf(0.0) }
                    var textValue1 by remember { mutableStateOf("") }
                    var textValue2 by remember { mutableStateOf("") }


                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Column {
                            Text(
                                text = "Poissonovo rozdelenie",
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
                                    value = textValue1,
                                    onValueChange = { textValue1 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValue2,
                                    onValueChange = { textValue2 = it },
                                    label = { Text("Počet") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )


                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Text(
                                    text = "Vysledok:  $vysledok",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val a = textValue1.toDouble()
                                    val b = textValue2.toInt()

                                    vysledok = PoissonDist(a, b)
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


fun BinomDist(pokusy: Int, pravdepodobnost: Double, uspechy: Int): Double {
    val Kombinacia = Faktorial(pokusy) / (Faktorial(uspechy) * Faktorial(pokusy - uspechy))
    return Kombinacia * Math.pow(pravdepodobnost, uspechy.toDouble()) * Math.pow(1 - pravdepodobnost, (pokusy - uspechy).toDouble())
}

fun Faktorial(n: Int): Int {
    return if (n == 0) 1 else n * Faktorial(n - 1)
}

fun GeoDist(lambda: Double, x: Double): Double {
    return if (x < 0) {
        0.0
    } else {
        lambda * exp(-lambda * x)
    }
}


fun HypGeoDist(velkostPopulacie: Int, pocetUspechov: Int, velkostVzorky: Int, pocetVyzrebovanychUspechov: Int): Double {
    val citatel = Kombinacia(pocetUspechov, pocetVyzrebovanychUspechov) * Kombinacia(velkostPopulacie - pocetUspechov, velkostVzorky - pocetVyzrebovanychUspechov)
    val menovatel = Kombinacia(velkostPopulacie, velkostVzorky)
    return citatel.toDouble() / menovatel.toDouble()
}

fun Kombinacia(n: Int, k: Int): Long {
    var vysledok: Long = 1
    for (i in 1..k) {
        vysledok = vysledok * (n - i + 1) / i
    }
    return vysledok
}

fun PoissonDist(lamda: Double, k: Int): Double {
    return (Math.pow(lamda, k.toDouble()) * Math.exp(-lamda)) / Faktorial(k)
}