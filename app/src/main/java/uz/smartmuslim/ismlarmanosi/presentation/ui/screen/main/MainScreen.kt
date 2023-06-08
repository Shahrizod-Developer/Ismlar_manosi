package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.Navigator

class MainScreen:AndroidScreen() {

    @Composable
    override fun Content() {

    }

    private fun navigateToDestination(item: NavigationItem, navController: NavController) {
        when (item) {
            NavigationItems.Home -> navController.navigate("home")
            NavigationItems.Search -> navController.navigate("search")
            NavigationItems.Article -> navController.navigate("article")
            NavigationItems.Favorite -> navController.navigate("favorite")
            NavigationItems.Settings -> navController.navigate("settings")
        }
    }
}

@Composable
fun MainScreenContent(
    uiState: MainUiState,
    onEventDispatcher:(MainIntent) -> Unit,
    navigator:Navigator
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Main Screen Content",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { onEventDispatcher(MainIntent.ButtonClicked) },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(text = "Click Me")
        }
        Text(text = "UI State: ${uiState.data}")
        Button(
            onClick = { navigator.disposeBehavior },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Go to Other Screen")
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController){

    val items = listOf(
        NavigationItems.Home,
        NavigationItems.Search,
        NavigationItems.Article,
        NavigationItems.Favorite,
        NavigationItems.Settings
    )

    var currentPage by remember { mutableStateOf(NavigationItems.Home) }

    MyBottomNavigation(items = items, currentPage = currentPage) { item ->
        currentPage = item
    }
}
@Composable
fun MyBottomNavigation(
    items: List<NavigationItem>,
    currentPage: NavigationItem,
    onItemClick: (NavigationItem) -> Unit
) {
    // Define your custom BottomNavigation background color
    val backgroundColor = Color(0xFF123456)

    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = backgroundColor,
        elevation = 8.dp
    ) {
        items.forEach { item ->
            val isSelected = item == currentPage

            val itemBackgroundColor = if (isSelected) Color(0xFF789ABC) else backgroundColor

            BottomNavigationItem(
                selected = isSelected,
                onClick = { onItemClick(item) },
                modifier = Modifier.background(itemBackgroundColor),
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (isSelected) Color.White else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (isSelected) Color.White else Color.Gray
                    )
                }
            )
        }
    }
}


