package uz.smartmuslim.ismlarmanosi.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.smartmuslim.ismlarmanosi.data.repository.intro.IntroRepositoryImpl
import uz.smartmuslim.ismlarmanosi.domain.repository.intro.IntroRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindIntroRepository(impl: IntroRepositoryImpl): IntroRepository
}