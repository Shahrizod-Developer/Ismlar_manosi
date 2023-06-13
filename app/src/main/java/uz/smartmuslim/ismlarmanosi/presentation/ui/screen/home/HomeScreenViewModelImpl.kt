package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.smartmuslim.ismlarmanosi.domain.usecase.HomeUseCase
import uz.smartmuslim.ismlarmanosi.presentation.navigation.AppNavigation
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModelImpl @Inject constructor(
    private val useCase: HomeUseCase,
    private val navigation: AppNavigation
) :ViewModel(), HomeScreenViewModel{
    override fun onEventDispatchers(intent: HomeIntent) = intent {
        viewModelScope.launch(Dispatchers.IO) {

            useCase.getBoyNamesCount().collectLatest {
                reduce { HomeUiState() }
            }
        }
    }

    override val container: Container<HomeUiState, SideEffect> = container(HomeUiState())
}