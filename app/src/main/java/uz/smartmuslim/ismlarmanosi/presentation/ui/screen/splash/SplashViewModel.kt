package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.splash

import uz.smartmuslim.ismlarmanosi.utils.BaseViewModel

interface SplashViewModel : BaseViewModel<Unit, SplashUiState, Nothing>

data class SplashUiState(
    val isOpenMain: Boolean = false,
    val isOpenIntro: Boolean = false
)