package uz.smartmuslim.ismlarmanosi.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.OfferEntity
import uz.smartmuslim.ismlarmanosi.data.remote.response.OfferResponse

interface OfferApi {

    @POST("/add")
    fun addOffer(@Body offer: OfferResponse): Response<String>

}