package uz.smartmuslim.ismlarmanosi.domain.di

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.hilt.ScreenModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home.HomeModel
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.names.NamesModel
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.splash.SplashModel

@Module
@InstallIn(ActivityComponent::class)
abstract class HiltModule {

    @Binds
    @IntoMap
    @ScreenModelKey(SplashModel::class)
    abstract fun bindHiltSplashScreenModel(splashModel: SplashModel): ScreenModel

    @Binds
    @IntoMap
    @ScreenModelKey(HomeModel::class)
    abstract fun bindHiltHomeScreenModel(homeModel: HomeModel): ScreenModel

    @Binds
    @IntoMap
    @ScreenModelKey(NamesModel::class)
    abstract fun bindHiltNamesScreenModel(namesModel: NamesModel): ScreenModel


}


