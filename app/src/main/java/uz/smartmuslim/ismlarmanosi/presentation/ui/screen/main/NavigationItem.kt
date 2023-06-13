package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import uz.smartmuslim.ismlarmanosi.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.baseline_home_24, "Home")
    object Search : NavigationItem("search", R.drawable.baseline_search_24, "Search")
    object Article : NavigationItem("article", R.drawable.baseline_newspaper_24, "Article")
    object Favorite : NavigationItem("favorite", R.drawable.baseline_bookmark_border_24, "Favorite")
    object Settings : NavigationItem("settings", R.drawable.baseline_settings_24, "Settings")
}