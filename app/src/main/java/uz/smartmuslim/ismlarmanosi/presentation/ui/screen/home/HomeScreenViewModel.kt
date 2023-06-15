package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.smartmuslim.ismlarmanosi.domain.usecase.HomeUseCase
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCase: HomeUseCase,
) : ViewModel(), HomeScreenContract.ViewModel {

    init {

        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TTT", "syncNames")
            useCase.syncNames()
        }

        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            useCase.childrenNamesCount().collectLatest {
                Log.d("TTT", "viewmodel names = " + it)
                intent {
                    reduce {
                        HomeScreenContract.HomeUiState.Counts().copy(
                            girlNameCount = it.girlNamesCount,
                            boyNameCount = it.boyNamesCount
                        )
                    }
                }
            }
        }
    }

    override fun onEventDispatcher(intent: HomeScreenContract.HomeIntent) {

    }

    override val container =
        container<HomeScreenContract.HomeUiState, HomeScreenContract.HomeSideEffect>(
            HomeScreenContract.HomeUiState.Counts()
        )

}