package ks.connecttooffice10.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ks.connecttooffice10.ui.activity.Screen

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Screen.Documents,
        Screen.Rooms,
        Screen.Trash,
        Screen.Profile  // Профиль без индикатора
    )

    NavigationBar {
        val currentBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = currentBackStackEntry?.destination?.route

        items.forEach { screen ->
            val isSelected = currentRoute == screen.route

            NavigationBarItem(
                icon = {
                    if (isProfile(screen)) {
                        Icon(Icons.Default.Person, contentDescription = null)  // Только для профиля
                    } else {
                        Indicator(isSelected)  // Только индикатор для остальных
                    }
                },
                label = { Text(screen.route) },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val size = if (isSelected) 10.dp else 12.dp  // Чуть уменьшенная точка
    val shape = if (isSelected) CircleShape else TriangleShape
    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Black, shape)
    )
}


fun isProfile(screen: Screen) = screen == Screen.Profile

val TriangleShape = GenericShape { size, _ ->
    moveTo(size.width / 2, 0f)
    lineTo(0f, size.height)
    lineTo(size.width, size.height)
    close()
}
