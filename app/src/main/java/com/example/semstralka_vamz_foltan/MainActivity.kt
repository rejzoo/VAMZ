package com.example.semstralka_vamz_foltan



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext


import androidx.activity.enableEdgeToEdge


import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.semstralka_vamz_foltan.sampledata.DataPriklad
import com.example.semstralka_vamz_foltan.ui.theme.Kalkulacka
import com.example.semstralka_vamz_foltan.ui.theme.MainScreen
import com.example.semstralka_vamz_foltan.ui.theme.Priklad
import com.example.semstralka_vamz_foltan.ui.theme.Semstralka_VAMZ_FoltanTheme
import com.example.semstralka_vamz_foltan.ui.theme.TemaScreen
import com.example.semstralka_vamz_foltan.ui.theme.VyberTemy

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Semstralka_VAMZ_FoltanTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "main_screen") {
                    composable("main_screen") { MainScreen(navController) }
                    composable("vyber_temy") { VyberTemy(navController) }
                    composable(

                        route = "{topic}",
                        arguments = listOf(navArgument("topic") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val topic = backStackEntry.arguments?.getString("topic")
                        TemaScreen(navController, topic?.toInt())
                    }
                    composable(
                        route = "priklad/{topic}",
                        arguments = listOf(navArgument("topic") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val cisloPrikladu = backStackEntry.arguments?.getString("topic")
                        Priklad(DataPriklad(cisloPrikladu?.toInt() , LocalContext.current)) }
                    composable("Kalkulacka") { Kalkulacka() }


                }
            }
        }
    }
}










