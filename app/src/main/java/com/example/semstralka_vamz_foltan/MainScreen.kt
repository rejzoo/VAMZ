package com.example.semstralka_vamz_foltan


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
    VyberTemy(navController = navController)
}
