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
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
fun Kalkulacka() {
    var vysledokBin by remember { mutableStateOf(0.0) }
    var textValueBin by remember { mutableStateOf("") }
    var textValueBin2 by remember { mutableStateOf("") }
    var textValueBin3 by remember { mutableStateOf("") }

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
                                    value = textValueBin,
                                    onValueChange = { textValueBin = it },
                                    label = { Text("n") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueBin2,
                                    onValueChange = { textValueBin2 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueBin3,
                                    onValueChange = { textValueBin3 = it },
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
                                    text = "Vysledok:  $vysledokBin",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val x = textValueBin.toIntOrNull() ?: 0
                                    val z = textValueBin2.toDouble()
                                    val y = textValueBin3.toIntOrNull() ?: 0
                                    vysledokBin = binomDist(x, z, y)
                                }) {
                                    Text(text = "Vypocitaj")
                                }
                            }
                        }
                    }
                }

                item {
                    var vysledokGeo by remember { mutableStateOf(0.0) }
                    var textValueGeo1 by remember { mutableStateOf("") }
                    var textValueGeo2 by remember { mutableStateOf("") }


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
                                    value = textValueGeo1,
                                    onValueChange = { textValueGeo1 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueGeo2,
                                    onValueChange = { textValueGeo2 = it },
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
                                    text = "Vysledok:  $vysledokGeo",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val a = textValueGeo1.toDouble()
                                    val b = textValueGeo2.toDouble()

                                    vysledokGeo = geoDist(a, b)
                                }) {
                                    Text(text = "Vypocitaj")
                                }
                            }
                        }
                    }
                }



                item {
                    var vysledokHypGeo by remember { mutableStateOf(0.0) }
                    var textValueHypGeo1 by remember { mutableStateOf("") }
                    var textValueHypGeo2 by remember { mutableStateOf("") }
                    var textValueHypGeo3 by remember { mutableStateOf("") }
                    var textValueHypGeo4 by remember { mutableStateOf("") }


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
                                    value = textValueHypGeo1,
                                    onValueChange = { textValueHypGeo1 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(50.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueHypGeo2,
                                    onValueChange = { textValueHypGeo2 = it },
                                    label = { Text("B") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(50.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueHypGeo3,
                                    onValueChange = { textValueHypGeo3 = it },
                                    label = { Text("C") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(50.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )
                                TextField(
                                    value = textValueHypGeo4,
                                    onValueChange = { textValueHypGeo4 = it },
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
                                    text = "Vysledok:  $vysledokHypGeo",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val a = textValueHypGeo1.toIntOrNull() ?: 0
                                    val b = textValueHypGeo2.toIntOrNull() ?: 0
                                    val c = textValueHypGeo3.toIntOrNull() ?: 0
                                    val d = textValueHypGeo4.toIntOrNull() ?: 0

                                    vysledokHypGeo = hypGeoDist(a, b, c, d)
                                }) {
                                    Text(text = "Vypocitaj")
                                }
                            }
                        }
                    }
                }

                item {
                    var vysledokPoi by remember { mutableStateOf(0.0) }
                    var textValuePoi1 by remember { mutableStateOf("") }
                    var textValuePoi2 by remember { mutableStateOf("") }


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
                                    value = textValuePoi1,
                                    onValueChange = { textValuePoi1 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValuePoi2,
                                    onValueChange = { textValuePoi2 = it },
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
                                    text = "Vysledok:  $vysledokPoi",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val a = textValuePoi1.toDouble()
                                    val b = textValuePoi2.toInt()

                                    vysledokPoi = poissonDist(a, b)
                                }) {
                                    Text(text = "Vypocitaj")
                                }
                            }
                        }
                    }
                }

                item {
                    var vysledokNor by remember { mutableStateOf(0.0) }
                    var textValueNor1 by remember { mutableStateOf("") }
                    var textValueNor2 by remember { mutableStateOf("") }
                    var textValueNor3 by remember { mutableStateOf("") }


                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Column {
                            Text(
                                text = "Normalne rozdelenie",
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
                                    value = textValueNor1,
                                    onValueChange = { textValueNor1 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueNor2,
                                    onValueChange = { textValueNor2 = it },
                                    label = { Text("B") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueNor3,
                                    onValueChange = { textValueNor3 = it },
                                    label = { Text("C") },
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
                                    text = "Vysledok:  $vysledokNor",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val a = textValueNor1.toDouble()
                                    val b = textValueNor2.toDouble()
                                    val c = textValueNor3.toDouble()

                                    vysledokNor = NormalDist(a, b , c)
                                }) {
                                    Text(text = "Vypocitaj")
                                }
                            }
                        }
                    }
                }

                item {
                    var vysledokRov by remember { mutableStateOf(0.0) }
                    var textValueRov1 by remember { mutableStateOf("") }
                    var textValueRov2 by remember { mutableStateOf("") }
                    var textValueRov3 by remember { mutableStateOf("") }


                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Column {
                            Text(
                                text = "Rovnomerné rozdelenie",
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
                                    value = textValueRov1,
                                    onValueChange = { textValueRov1 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueRov2,
                                    onValueChange = { textValueRov2 = it },
                                    label = { Text("B") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueRov3,
                                    onValueChange = { textValueRov3 = it },
                                    label = { Text("C") },
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
                                    text = "Vysledok:  $vysledokRov",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val a = textValueRov1.toDouble()
                                    val b = textValueRov2.toDouble()
                                    val c = textValueRov3.toDouble()

                                    vysledokRov = uniformDist(a, b , c)
                                }) {
                                    Text(text = "Vypocitaj")
                                }
                            }
                        }
                    }
                }

                item {
                    var vysledokStud by remember { mutableStateOf(0.0) }
                    var textValueStud1 by remember { mutableStateOf("") }
                    var textValueStud2 by remember { mutableStateOf("") }



                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Column {
                            Text(
                                text = "Studentovo rozdelenie",
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
                                    value = textValueStud1,
                                    onValueChange = { textValueStud1 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueStud2,
                                    onValueChange = { textValueStud2 = it },
                                    label = { Text("B") },
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
                                    text = "Vysledok:  $vysledokStud",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val a = textValueStud1.toInt()
                                    val b = textValueStud2.toDouble()


                                    vysledokStud = StudentovoRozdelenie(a, b)
                                }) {
                                    Text(text = "Vypocitaj")
                                }
                            }
                        }
                    }
                }

                item {
                    var vysledokFis by remember { mutableStateOf(0.0) }
                    var textValueFis1 by remember { mutableStateOf("") }
                    var textValueFis2 by remember { mutableStateOf("") }
                    var textValueFis3 by remember { mutableStateOf("") }


                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Column {
                            Text(
                                text = "Fisherovo rozdelenie",
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
                                    value = textValueFis1,
                                    onValueChange = { textValueFis1 = it },
                                    label = { Text("Pi") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueFis2,
                                    onValueChange = { textValueFis2 = it },
                                    label = { Text("B") },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .width(80.dp),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                                )

                                TextField(
                                    value = textValueFis3,
                                    onValueChange = { textValueFis3 = it },
                                    label = { Text("B") },
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
                                    text = "Vysledok:  $vysledokFis",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 12.dp)
                                )

                                Button(onClick = {
                                    val a = textValueFis1.toInt()
                                    val b = textValueFis2.toInt()
                                    val c = textValueFis3.toDouble()

                                    vysledokFis = FisherovoSnedecorovoRozdelenie(a, b, c)
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


fun binomDist(pokusy: Int?, pravdepodobnost: Double?, uspechy: Int?): Double {
    if (pokusy == null || pravdepodobnost == null || uspechy == null) return 0.0
    val kombinacia = faktorial(pokusy) / (faktorial(uspechy) * faktorial(pokusy - uspechy))
    return kombinacia * Math.pow(pravdepodobnost, uspechy.toDouble()) * (1 - pravdepodobnost).pow((pokusy - uspechy).toDouble())
}

fun faktorial(n: Int?): Int {
    if (n == null) return 1
    return if (n == 0) 1 else n * faktorial(n - 1)
}

fun geoDist(lambda: Double?, x: Double?): Double {
    if (lambda == null || x == null || x < 0) return 0.0
    return lambda * exp(-lambda * x)
}

fun hypGeoDist(velkostPopulacie: Int?, pocetUspechov: Int?, velkostVzorky: Int?, pocetVyzrebovanychUspechov: Int?): Double {
    if (velkostPopulacie == null || pocetUspechov == null || velkostVzorky == null || pocetVyzrebovanychUspechov == null) return 0.0
    val citatel = kombinacia(pocetUspechov, pocetVyzrebovanychUspechov) * kombinacia(velkostPopulacie - pocetUspechov, velkostVzorky - pocetVyzrebovanychUspechov)
    val menovatel = kombinacia(velkostPopulacie, velkostVzorky)
    return citatel.toDouble() / menovatel.toDouble()
}

fun kombinacia(n: Int?, k: Int?): Long {
    if (n == null || k == null) return 0
    var vysledok: Long = 1
    for (i in 1..k) {
        vysledok = vysledok * (n - i + 1) / i
    }
    return vysledok
}

fun poissonDist(lamda: Double?, k: Int?): Double {
    if (lamda == null || k == null) return 0.0
    return (Math.pow(lamda, k.toDouble()) * Math.exp(-lamda)) / faktorial(k)
}

fun NormalDist(mean: Double?, stdDev: Double?, x: Double?): Double {
    if (mean == null || stdDev == null || x == null) return 0.0
    val exponent = -(x - mean).pow(2) / (2 * stdDev.pow(2))
    return (1 / (stdDev * sqrt(2 * Math.PI))) * exp(exponent)
}

fun uniformDist(min: Double?, max: Double?, x: Double?): Double {
    if (min == null || max == null || x == null) return 0.0
    return if (x in min..max) 1 / (max - min) else 0.0
}

fun StudentovoRozdelenie(df: Int?, x: Double?): Double {
    if (df == null || x == null) return 0.0

    val citatel = gamma((df + 1) / 2.0)
    val menovatel = sqrt(df * Math.PI) * gamma(df / 2.0)
    val koeficient = citatel / menovatel
    val exponent = -(df + 1) / 2.0

    return koeficient * (1 + x.pow(2.0) / df).pow(exponent)
}

fun gamma(x: Double): Double {
    if (x == 1.0) return 1.0
    if (x == 0.5) return sqrt(Math.PI)
    return (x - 1) * gamma(x - 1)
}

fun FisherovoSnedecorovoRozdelenie(df1: Int?, df2: Int?, x: Double?): Double {
    if (df1 == null || df2 == null || x == null || x <= 0) return 0.0

    val citatel = gamma((df1 + df2) / 2.0)
    val menovatel = gamma(df1 / 2.0) * gamma(df2 / 2.0)
    val exponencialnyExponent = (df1 * ln(df1 * x / (df1 * x + df2))).pow(df1 / 2.0)
    val koeficient = sqrt((df1 / df2).toDouble()) / (x * citatel / menovatel)

    return koeficient * exponencialnyExponent
}