package uz.smartmuslim.ismlarmanosi.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.smartmuslim.ismlarmanosi.presentation.direction.SplashScreenDirection
import uz.smartmuslim.ismlarmanosi.presentation.direction.impl.SplashScreenDirectionImpl
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionsModule {

    @[Binds Singleton]
    fun bindSplashScreenDirection(impl: SplashScreenDirectionImpl): SplashScreenDirection



}