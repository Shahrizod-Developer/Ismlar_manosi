package uz.smartmuslim.ismlarmanosi

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.smartmuslim.ismlarmanosi.presentation.navigation.NavigationHandler
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.splash.SplashScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.IsmlarManosiTheme
import javax.inject.Inject

@Suppress("OPT_IN_IS_NOT_ENABLED")
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationHandler: NavigationHandler

    @OptIn(ExperimentalAnimationApi::class)
    @SuppressLint("FlowOperatorInvokedInComposition", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IsmlarManosiTheme {
                Navigator(screen = SplashScreen(),
                    onBackPressed = {
                        true
                    }
                ) { navigator ->
                    navigationHandler.navStack
                        .onEach {
                            it.invoke(navigator)
                        }.launchIn(lifecycleScope)
                    SlideTransition(navigator)
                }
            }
        }
    }
}
