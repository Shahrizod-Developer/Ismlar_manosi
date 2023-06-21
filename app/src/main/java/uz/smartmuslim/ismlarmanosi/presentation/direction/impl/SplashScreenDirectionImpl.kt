package uz.smartmuslim.ismlarmanosi.presentation.direction.impl

import cafe.adriel.voyager.navigator.Navigator
import uz.smartmuslim.ismlarmanosi.presentation.direction.SplashScreenDirection
import uz.smartmuslim.ismlarmanosi.presentation.navigation.AppNavigator
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main.MainScreen
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator
) : SplashScreenDirection {
    override suspend fun openMainScreen() {
        navigator.replace(MainScreen())
    }

}