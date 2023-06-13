package uz.smartmuslim.ismlarmanosi.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.smartmuslim.ismlarmanosi.data.repository.name.NameRepository
import uz.smartmuslim.ismlarmanosi.data.repository.name.impl.NameRepositoryImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindNameRepository(impl: NameRepositoryImpl): NameRepository
}