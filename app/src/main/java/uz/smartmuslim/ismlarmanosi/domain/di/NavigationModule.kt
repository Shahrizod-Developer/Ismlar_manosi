package uz.smartmuslim.ismlarmanosi.domain.di
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.smartmuslim.ismlarmanosi.presentation.navigation.AppNavigation
import uz.smartmuslim.ismlarmanosi.presentation.navigation.NavigationDispatcher
import uz.smartmuslim.ismlarmanosi.presentation.navigation.NavigationHandler


@Module
@InstallIn(SingletonComponent::class)
interface NavigatorModule {

    @Binds
    fun appNavigator(dispatcher: NavigationDispatcher): AppNavigation

    @Binds
    fun navigationHandler(dispatcher: NavigationDispatcher): NavigationHandler
}