package uz.smartmuslim.ismlarmanosi.presentation.direction.impl

import uz.smartmuslim.ismlarmanosi.presentation.navigation.AppNavigator
import uz.smartmuslim.ismlarmanosi.presentation.direction.HomeScreenDirection
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.names.NamesScreen
import javax.inject.Inject

class HomeScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator
) : HomeScreenDirection {
    override suspend fun openNamesScreen(status: Int) {
        navigator.replaceAll(NamesScreen(status))
    }
}