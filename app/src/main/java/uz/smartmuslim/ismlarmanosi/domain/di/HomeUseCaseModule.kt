package uz.smartmuslim.ismlarmanosi.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.smartmuslim.ismlarmanosi.domain.usecase.HomeUseCase
import uz.smartmuslim.ismlarmanosi.domain.usecase.impl.HomeUseCaseImpl


@Module
@InstallIn(ViewModelComponent::class)
interface HomeUseCaseModule {

    @Binds
    fun bindHomeUseCaseModule(impl: HomeUseCaseImpl): HomeUseCase

}