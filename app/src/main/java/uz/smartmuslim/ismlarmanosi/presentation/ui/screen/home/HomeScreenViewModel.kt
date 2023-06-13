package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home

import uz.smartmuslim.ismlarmanosi.utils.BaseViewModel

interface HomeScreenViewModel : BaseViewModel<HomeIntent, HomeUiState, SideEffect>

sealed class HomeIntent {


}

data class HomeUiState(
    val boyNameCount: Int = 0,
    val girlNameCount: Int = 0
)

data class SideEffect(
    val openWinGame: Boolean = false,
    val openQuitGame: Boolean = false
)
