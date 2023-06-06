package uz.smartmuslim.ismlarmanosi.presentation.direction.impl

import cafe.adriel.voyager.navigator.Navigator
import uz.smartmuslim.ismlarmanosi.presentation.direction.SplashScreenDirection
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main.MainScreen
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : SplashScreenDirection {
    override suspend fun navigateToMain() {
        navigator.replace(MainScreen())
    }
}