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

}