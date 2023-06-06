package uz.smartmuslim.ismlarmanosi.data.remote.api

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ImageApi {

    @GET("/get/{hashId}")
    fun downloadFileByHashId(@Path("hashId") hashId: String): Response<ResponseBody>

    @Multipart
    @POST("/upload")
    fun uploadFile(@Part("file") file: MultipartBody.Part): Call<String>
}