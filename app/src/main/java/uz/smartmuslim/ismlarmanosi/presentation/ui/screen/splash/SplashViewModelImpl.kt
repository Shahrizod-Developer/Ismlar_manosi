package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.smartmuslim.ismlarmanosi.presentation.navigation.AppNavigation
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main.MainScreen
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val navigator: AppNavigation
) : SplashViewModel, ViewModel() {
    override val container: Container<SplashUIState, Nothing> =
        container(SplashUIState("Splash Screen"))

    override fun onEventDispatcher(intent: SplashIntent) = intent {
        when (intent) {

            SplashIntent.OpenMaiScreen -> {
                delay(2000)
                navigator.navigateTo(MainScreen())
            }
        }
    }
}