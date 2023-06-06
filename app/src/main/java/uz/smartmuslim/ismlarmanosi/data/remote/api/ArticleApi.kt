package uz.smartmuslim.ismlarmanosi.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.ArticleEntity

interface ArticleApi {

    @GET("/get/{id}")
    fun getById(@Path("id") id: String): Response<ArticleEntity>

    @GET("/search")
    fun search(@Query("search") search: String): Response<List<ArticleEntity>>
}