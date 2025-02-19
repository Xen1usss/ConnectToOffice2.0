package ks.connecttooffice10.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ks.connecttooffice10.ui.navigation.Screen
import ks.connecttooffice10.ui.components.BottomNavigationBar
import ks.connecttooffice10.ui.screen.DocumentsScreen
import ks.connecttooffice10.ui.screen.ProfileScreen
import ks.connecttooffice10.ui.screen.RoomsScreen
import ks.connecttooffice10.ui.screen.TrashScreen
import ks.connecttooffice10.ui.theme.ConnectToOffice10Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConnectToOffice10Theme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController) }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Documents.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Documents.route) { DocumentsScreen() }
                        composable(Screen.Rooms.route) { RoomsScreen() }
                        composable(Screen.Trash.route) { TrashScreen() }
                        composable(Screen.Profile.route) {
                            val context = LocalContext.current
                            ProfileScreen(context = context)
                        }
                    }
                }
            }
        }
    }
}

