package com.example.semstralka_vamz_foltan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.semstralka_vamz_foltan.ui.theme.DataPriklad
import com.example.semstralka_vamz_foltan.ui.theme.Kalkulacka
import com.example.semstralka_vamz_foltan.ui.theme.Priklad
import com.example.semstralka_vamz_foltan.ui.theme.Semstralka_VAMZ_FoltanTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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


                    //composable("Quiz") { Quiz(navController) }
                }
            }
        }
    }
}
