package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.names

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.androidx.AndroidScreen
import org.orbitmvi.orbit.ContainerHost

sealed class NamesScreenContract {
    interface ViewModel: ContainerHost<NamesUiState, NamesSideEffect> {
        fun onEventDispatcher(intent: NamesIntent)
    }

    sealed interface NamesUiState {
        data class Counts(
            val boyNameCount: Int = 0,
            val girlNameCount: Int = 0
        ) : NamesUiState
    }

    sealed interface NamesSideEffect {
        data class Toast(val message: String): NamesSideEffect
    }

    sealed interface NamesIntent {

    }
}
