package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.article.ArticleScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.favorite.FavoriteScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home.HomeScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.search.SearchScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.settings.SettingsScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.Bg_Main_Color

class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val navController = rememberNavController()
        MainScreenContent(navController = navController)
    }
}

@Composable
fun MainScreenContent(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController as NavHostController)
            }
        },
        backgroundColor = Color.White // Set background color to avoid the white flashing when you switch between screens
    )
}

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen().Content()
        }
        composable(NavigationItem.Search.route) {
            SearchScreen().Content()
        }
        composable(NavigationItem.Article.route) {
            ArticleScreen().Content()
        }
        composable(NavigationItem.Favorite.route) {
            FavoriteScreen().Content()
        }
        composable(NavigationItem.Settings.route) {
            SettingsScreen().Content()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Article,
        NavigationItem.Favorite,
        NavigationItem.Settings
    )

    BottomNavigation(
        backgroundColor = Bg_Main_Color,
        contentColor = Color.Green
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp
                    )
                },
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.DarkGray,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // popUpTo() is not needed in this case
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
