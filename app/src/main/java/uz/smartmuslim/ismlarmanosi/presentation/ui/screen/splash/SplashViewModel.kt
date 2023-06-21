package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.splash

import org.orbitmvi.orbit.ContainerHost

sealed interface SplashContract {

    sealed interface SplashModel : ContainerHost<Any, Any>{
        fun onEventDispatcher(intent: SplashIntent)
    }

    sealed interface SplashIntent {
        object OpenMaiScreen : SplashIntent
    }

}
