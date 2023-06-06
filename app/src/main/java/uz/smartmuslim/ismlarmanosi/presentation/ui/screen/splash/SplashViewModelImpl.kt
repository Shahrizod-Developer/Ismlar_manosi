package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import uz.smartmuslim.ismlarmanosi.data.local.shp.MySharedPreference
import javax.inject.Inject


@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val mySharedPreference: MySharedPreference
) : SplashViewModel, ViewModel() {
    override fun onEventDispatchers(intent: Unit) {}

    override val container: Container<SplashUiState, Nothing>  = container(SplashUiState())
}