package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name:String,
    val route:String,
    val icon:ImageVector
)
val bottomNavItems = listOf(
    BottomNavItem(
        name = "Home",
        route = "home",
        icon = Icons.Rounded.Home,
    ),
    BottomNavItem(
        name = "Search",
        route = "search",
        icon = Icons.Rounded.Search,
    ),
    BottomNavItem(
        name = "Article",
        route = "article",
        icon = Icons.Rounded.ShoppingCart,
    ),
    BottomNavItem(
        name = "Bookmark",
        route = "bookmark",
        icon = Icons.Rounded.AccountBox,
    ),
    BottomNavItem(
        name = "Settings",
        route = "settings",
        icon = Icons.Rounded.Settings,
    )
)