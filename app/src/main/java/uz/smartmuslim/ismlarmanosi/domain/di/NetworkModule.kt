package uz.smartmuslim.ismlarmanosi.domain.di

import com.chuckerteam.chucker.api.Chucker
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.smartmuslim.ismlarmanosi.app.App
import uz.smartmuslim.ismlarmanosi.data.remote.api.ArticleApi
import uz.smartmuslim.ismlarmanosi.data.remote.api.ImageApi
import uz.smartmuslim.ismlarmanosi.data.remote.api.NameApi
import uz.smartmuslim.ismlarmanosi.data.remote.api.OfferApi


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideClient(loggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .addInterceptor(ChuckerInterceptor(App.instance)).build()

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("sdf")
            .client(client)
            .build()

    @Provides
    fun provideNameApi(retrofit: Retrofit): NameApi = retrofit.create(NameApi::class.java)

    @Provides
    fun provideImageApi(retrofit: Retrofit): ImageApi = retrofit.create(ImageApi::class.java)

    @Provides
    fun provideOfferApi(retrofit: Retrofit): OfferApi = retrofit.create(OfferApi::class.java)

    @Provides
    fun provideArticleApi(retrofit: Retrofit): ArticleApi = retrofit.create(ArticleApi::class.java)
}