package uz.smartmuslim.ismlarmanosi.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import uz.smartmuslim.ismlarmanosi.domain.usecase.HomeUseCase
import uz.smartmuslim.ismlarmanosi.domain.usecase.NamesUseCase
import uz.smartmuslim.ismlarmanosi.domain.usecase.impl.HomeUseCaseImpl
import uz.smartmuslim.ismlarmanosi.domain.usecase.impl.NamesUseCaseImpl


@Module
@InstallIn(ActivityComponent::class)
interface UseCaseModule {

    @Binds
    fun bindHomeUseCaseModule(impl: HomeUseCaseImpl): HomeUseCase

    @Binds
    fun bindNamesUseCaseModule(impl: NamesUseCaseImpl): NamesUseCase

}