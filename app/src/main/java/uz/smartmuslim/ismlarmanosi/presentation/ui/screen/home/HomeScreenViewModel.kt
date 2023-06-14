package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home

import uz.smartmuslim.ismlarmanosi.utils.BaseViewModel

interface HomeScreenViewModel : BaseViewModel<HomeIntent, HomeUiState, Any>

sealed interface HomeIntent {


}

data class HomeUiState(
    var boyNamesCount: Int = 0,
    var girlNameCount: Int = 0
)

