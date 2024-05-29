package com.example.semstralka_vamz_foltan
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.semstralka_vamz_foltan.ui.theme.Semstralka_VAMZ_FoltanTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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
                        route = "tema/{topic}",
                        arguments = listOf(navArgument("topic") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val topic = backStackEntry.arguments?.getString("topic")
                        TemaScreen(navController, topic)
                    }
                }
            }
        }
    }
}









