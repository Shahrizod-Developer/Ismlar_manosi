package uz.smartmuslim.ismlarmanosi.domain.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.ArticleDao
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.ImageDao
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.NameDao
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.OfferDao
import uz.smartmuslim.ismlarmanosi.data.local.room.database.AppDatabase
import uz.smartmuslim.ismlarmanosi.data.local.shp.MySharedPreference
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @[Provides Singleton]
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "names_meaning").build()

    @[Provides Singleton]
    fun provideImageDao(appDatabase: AppDatabase): ImageDao = appDatabase.imageDao()

    @[Provides Singleton]
    fun provideArticleDao(appDatabase: AppDatabase): ArticleDao = appDatabase.articleDao()

    @[Provides Singleton]
    fun provideNameDao(appDatabase: AppDatabase): NameDao = appDatabase.nameDao()

    @[Provides Singleton]
    fun provideOfferDao(appDatabase: AppDatabase): OfferDao = appDatabase.offerDao()

    @[Provides Singleton]
    fun provideSharedPrefs(
        @ApplicationContext context: Context,
        sharedPreferences: SharedPreferences
    ): MySharedPreference =
        MySharedPreference(context, sharedPreferences)

    @[Provides Singleton]
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("app_data", Context.MODE_PRIVATE)

}