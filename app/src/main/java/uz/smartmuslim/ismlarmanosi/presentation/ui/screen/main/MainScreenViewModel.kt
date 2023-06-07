package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main

import uz.smartmuslim.ismlarmanosi.utils.AppViewModel


interface MainViewModel : AppViewModel<MainIntent, MainUiState, MySideEffect> {
}

interface MainScreenViewModel {
}

sealed class MainIntent {

}

sealed interface MainUiState {}


sealed interface MySideEffect {}