package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.article.ArticlePage
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.favorite.FavoritePage
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home.HomePage
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.search.SearchPage
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.settings.SettingsPage
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.IsmlarManosiTheme


class MainScreen : AndroidScreen() {

    @Composable
    override fun Content() {

        IsmlarManosiTheme {
            MainContent()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun MainContent() {
    TabNavigator(tab = HomePage) {
        Scaffold(
            content = {
                CurrentTab()
            },
            bottomBar = {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {
                    BottomNavigation(
                        modifier = Modifier
                            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                            .background(Color.White),
                        contentColor = Color.White
                    ) {
                        TabNavigatorItem(tab = HomePage)
                        TabNavigatorItem(tab = SearchPage)
                        TabNavigatorItem(tab = ArticlePage)
                        TabNavigatorItem(tab = FavoritePage)
                        TabNavigatorItem(tab = SettingsPage)
                    }
                }
            }
        )
    }
}

@Composable
fun RowScope.TabNavigatorItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        label = {
            androidx.compose.material.Text(
                text = tab.options.title,
                modifier = Modifier.padding(vertical = 8.dp),
                fontSize = 10.sp
            )
        },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) }
    )
}