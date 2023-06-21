package uz.smartmuslim.ismlarmanosi.domain.di
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.smartmuslim.ismlarmanosi.presentation.navigation.AppNavigator
import uz.smartmuslim.ismlarmanosi.presentation.navigation.NavigationDispatcher
import uz.smartmuslim.ismlarmanosi.presentation.navigation.NavigationHandler

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun bindAppNavigator(impl: NavigationDispatcher): AppNavigator

    @Binds
    fun bindNavigationHandler(impl: NavigationDispatcher): NavigationHandler
}


