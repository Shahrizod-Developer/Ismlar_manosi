package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import uz.smartmuslim.ismlarmanosi.R

data class NavigationItem(
    val icon: ImageVector,
    val title: String
)

object NavigationItems {
    val Home = NavigationItem(Icons.Filled.Home, "Home")
    val Search = NavigationItem(Icons.Filled.Search, "Search")
    val Article = NavigationItem(Icons.Filled.AccountBox, "Article")
    val Favorite = NavigationItem(Icons.Filled.Favorite, "Favorite")
    val Settings = NavigationItem(Icons.Filled.Settings, "Settings")
}