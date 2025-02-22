@file:OptIn(ExperimentalMaterial3Api::class)

package ks.connecttooffice10.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ks.connecttooffice10.ui.components.BottomNavigationBar
import ks.connecttooffice10.ui.navigation.Screen


@Composable
@Preview
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) },
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