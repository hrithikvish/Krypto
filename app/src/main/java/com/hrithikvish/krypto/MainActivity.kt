package com.hrithikvish.krypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hrithikvish.krypto.presentation.Screen
import com.hrithikvish.krypto.presentation.coin_detail.CoinDetailScreen
import com.hrithikvish.krypto.presentation.coin_list.CoinListScreen
import com.hrithikvish.krypto.presentation.ui.theme.KryptoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KryptoTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route,
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route,
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}",
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}