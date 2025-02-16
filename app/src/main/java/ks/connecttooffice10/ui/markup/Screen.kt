package ks.connecttooffice10.ui.markup

sealed class Screen(val route: String) {
    object Documents : Screen("documents")
    object Rooms : Screen("rooms")
    object Trash : Screen("trash")
    object Profile : Screen("profile")
}