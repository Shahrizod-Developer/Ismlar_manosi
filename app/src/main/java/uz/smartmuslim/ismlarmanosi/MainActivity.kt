package uz.smartmuslim.ismlarmanosi

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.smartmuslim.ismlarmanosi.presentation.navigation.NavigationHandler
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home.HomeScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main.MainScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.names.NamesScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.splash.SplashScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.IsmlarManosiTheme
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationHandler: NavigationHandler

    @SuppressLint("CoroutineCreationDuringComposition", "FlowOperatorInvokedInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IsmlarManosiTheme() {
                Navigator(screen = SplashScreen()) { navigator ->
                    navigationHandler.navigationStack
                        .onEach { it.invoke(navigator) }
                        .launchIn(lifecycleScope)
                    CurrentScreen()
                }
            }
        }
    }
}
