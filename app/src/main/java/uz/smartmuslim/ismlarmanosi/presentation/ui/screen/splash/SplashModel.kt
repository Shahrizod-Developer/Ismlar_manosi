package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.splash

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.intent
import uz.smartmuslim.ismlarmanosi.presentation.direction.SplashScreenDirection
import javax.inject.Inject

class SplashModel@Inject constructor(
    private val direction: SplashScreenDirection
) : SplashContract.SplashModel, ScreenModel {
    override fun onEventDispatcher(intent: SplashContract.SplashIntent) {
        when (intent) {
            SplashContract.SplashIntent.OpenMaiScreen -> {
                intent {
                    delay(2000)
                    direction.openMainScreen()
                }
            }
        }
    }

    override val container = coroutineScope.container<Any, Any>(Any())

}