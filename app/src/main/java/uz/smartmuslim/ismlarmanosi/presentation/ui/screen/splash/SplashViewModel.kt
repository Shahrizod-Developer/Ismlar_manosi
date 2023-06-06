package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.splash

import uz.smartmuslim.ismlarmanosi.utils.AppViewModel
import uz.smartmuslim.ismlarmanosi.utils.BaseViewModel

interface SplashViewModel : AppViewModel<SplashIntent, SplashUIState, Nothing> {
}

sealed class SplashIntent {
    object OpenMaiScreen: SplashIntent()
}

data class SplashUIState(
    val title: String
)