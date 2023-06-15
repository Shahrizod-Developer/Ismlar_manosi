package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home

import org.orbitmvi.orbit.ContainerHost

sealed class HomeScreenContract {
    interface ViewModel:ContainerHost<HomeUiState, HomeSideEffect>{
        fun onEventDispatcher(intent: HomeIntent)
    }

    sealed interface HomeUiState {
        data class Counts(
            val boyNameCount: Int = 0,
            val girlNameCount: Int = 0
        ) : HomeUiState
    }

    sealed interface HomeSideEffect {
        data class Toast(val message: String): HomeSideEffect
    }

    sealed interface HomeIntent {

    }
}