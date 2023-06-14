package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home

import uz.smartmuslim.ismlarmanosi.utils.BaseViewModel

interface HomeScreenViewModel : BaseViewModel<HomeIntent, HomeUiState, SideEffect>

sealed interface HomeIntent {

    data class BoysNameCount(var count: Int) : HomeIntent

    data class GirlsNameCount(var count: Int) : HomeIntent

}

sealed interface HomeUiState {

}

sealed interface SideEffect {
    data class Message(val message: String) : SideEffect
    data class Error(val error: String) : SideEffect
}
