package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.smartmuslim.ismlarmanosi.domain.usecase.HomeUseCase
import uz.smartmuslim.ismlarmanosi.presentation.direction.HomeScreenDirection
import uz.smartmuslim.ismlarmanosi.presentation.direction.MainScreenDirection
import javax.inject.Inject


class HomeModel @Inject constructor(
    private val useCase: HomeUseCase,
    private val direction: MainScreenDirection
) : ScreenModel, HomeScreenContract.ViewModel {

    init {

        coroutineScope.launch(Dispatchers.IO) {
            useCase.syncNames()
        }

        coroutineScope.launch {
            useCase.childrenNamesCount().collectLatest {
                intent {
                    reduce {
                        HomeScreenContract.HomeUiState.Counts(
                            girlNameCount = it.girlNamesCount,
                            boyNameCount = it.boyNamesCount
                        )
                    }
                }
            }
        }
    }

    override fun onEventDispatcher(intent: HomeScreenContract.HomeIntent) {

        when (intent) {

            is HomeScreenContract.HomeIntent.OpenNamesScreen -> {
                intent { direction.openNamesScreen(intent.status) }
            }
        }
    }

    override val container =
        coroutineScope.container<HomeScreenContract.HomeUiState, HomeScreenContract.HomeSideEffect>(
            HomeScreenContract.HomeUiState.Counts()
        )

}