package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main




interface MainScreenViewModel {
}

sealed class MainIntent {
    object ButtonClicked : MainIntent()
}

sealed interface MainUiState {val data: String}


sealed interface MySideEffect {}