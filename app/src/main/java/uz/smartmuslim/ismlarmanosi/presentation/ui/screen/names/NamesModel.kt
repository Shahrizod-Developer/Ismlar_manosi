package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.names

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.smartmuslim.ismlarmanosi.domain.usecase.NamesUseCase
import uz.smartmuslim.ismlarmanosi.utils.myLog
import javax.inject.Inject


class NamesModel @Inject constructor(
    private val useCase: NamesUseCase,
) : NamesScreenContract.Model, ScreenModel {


    init {
            getBoysName()
            getGirlsName()
    }

    override fun onEventDispatcher(intent: NamesScreenContract.NamesIntent) {}
    override val container =
        coroutineScope.container<NamesScreenContract.NamesUiState, NamesScreenContract.NamesSideEffect>(
            NamesScreenContract.NamesUiState.Names()
        )
    private fun getBoysName() {
        Log.d("TTT", "boy + ")
        coroutineScope.launch {
            intent {
                useCase.getAllBoysName().collectLatest {
                    reduce {
                        NamesScreenContract.NamesUiState.Names(boysNameList = it)
                    }
                }
            }
        }
    }

    private fun getGirlsName() {
        Log.d("TTT", "girl + ")
        coroutineScope.launch {
            intent {
                useCase.getAllGirlsName().collectLatest {
                    reduce {
                        NamesScreenContract.NamesUiState.Names(girlsNameList = it)
                    }
                }
            }
        }
    }

}