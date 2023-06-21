package uz.smartmuslim.ismlarmanosi.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import uz.smartmuslim.ismlarmanosi.presentation.direction.HomeScreenDirection
import uz.smartmuslim.ismlarmanosi.presentation.direction.MainScreenDirection
import uz.smartmuslim.ismlarmanosi.presentation.direction.SplashScreenDirection
import uz.smartmuslim.ismlarmanosi.presentation.direction.impl.HomeScreenDirectionImpl
import uz.smartmuslim.ismlarmanosi.presentation.direction.impl.MainScreenDirectionImpl
import uz.smartmuslim.ismlarmanosi.presentation.direction.impl.SplashScreenDirectionImpl
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
interface DirectionsModule {

    @Binds
    fun bindSplashScreenDirection(impl: SplashScreenDirectionImpl): SplashScreenDirection

    @Binds
    fun bindMainScreenDirection(impl: MainScreenDirectionImpl): MainScreenDirection

}