package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.names

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.androidx.AndroidScreen
import org.orbitmvi.orbit.ContainerHost
import uz.smartmuslim.ismlarmanosi.data.model.NameData

interface NamesScreenContract {
    interface Model : ContainerHost<NamesUiState, NamesSideEffect> {
        fun onEventDispatcher(intent: NamesIntent)
    }

    sealed interface NamesUiState {

        object InitState: NamesUiState
        data class Names(
            val boysNameList: List<NameData> = emptyList(),
            val girlsNameList: List<NameData> = emptyList()
        ) : NamesUiState
    }

    sealed interface NamesSideEffect {
        data class Toast(val message: String) : NamesSideEffect
    }

    sealed interface NamesIntent {
        data class NameDetail(val nameData: NameData) : NamesIntent
    }
}
