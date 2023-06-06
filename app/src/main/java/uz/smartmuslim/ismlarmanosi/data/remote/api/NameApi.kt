package uz.smartmuslim.ismlarmanosi.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import uz.smartmuslim.ismlarmanosi.data.remote.response.NameResponse

interface NameApi {

    @GET("/api/names/v1/")
    suspend fun getAllNames(): Response<List<NameResponse>>

    @GET("/api/names/v1/boys")
    suspend fun getAllBoyNames(): Response<List<NameResponse>>

    @GET("/api/names/v1/girls")
    suspend fun getAllGirlNames(): Response<List<NameResponse>>

    @GET("/api/names/v1/get/rukns")
    suspend fun getNamesByRuknAndGender(
        @Query("rukn") rukn: String,
        @Query("gender") gender: String
    ): Response<List<NameResponse>>

    @GET("/api/names/v1/get/rukn")
    suspend fun getNamesByRukn(
        @Query("rukn") rukn: String,
        @Query("gender") gender: String
    ): Response<List<NameResponse>>

    @GET("/get/{id}")
    fun getByName(@Path("id") id: String): Response<NameResponse>

    @GET("/get/seenCount/{id}")
    fun getSeenCount(@Path("id") id: String): Response<Int>

    @GET("/get/likeCount/{id}")
    fun getLikeCount(@Path("id") id: String): Response<Int>

    @GET("/search")
    fun searchByName(@Query("search") search: String): Response<List<NameResponse>>

}