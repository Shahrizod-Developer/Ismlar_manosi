package uz.smartmuslim.ismlarmanosi.presentation.direction.impl

import uz.smartmuslim.ismlarmanosi.presentation.direction.MainScreenDirection
import uz.smartmuslim.ismlarmanosi.presentation.direction.SplashScreenDirection
import uz.smartmuslim.ismlarmanosi.presentation.navigation.AppNavigator
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.names.NamesScreen
import javax.inject.Inject

class MainScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator
) : MainScreenDirection{
    override suspend fun openNamesScreen(status: Int) {
        navigator.stackLog()
        navigator.navigateTo(NamesScreen(status))
    }
}