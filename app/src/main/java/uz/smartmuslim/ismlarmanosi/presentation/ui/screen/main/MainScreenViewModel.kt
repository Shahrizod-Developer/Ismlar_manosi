package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main

import uz.smartmuslim.ismlarmanosi.utils.AppViewModel


interface MainViewModel : AppViewModel<MainIntent, MainUiState, MySideEffect> {
}

interface MainScreenViewModel {
}

sealed class MainIntent {
    object ButtonClicked : MainIntent()
}

sealed interface MainUiState {val data: String}


sealed interface MySideEffect {}