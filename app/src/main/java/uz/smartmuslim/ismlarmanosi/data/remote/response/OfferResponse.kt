package uz.smartmuslim.ismlarmanosi.data.remote.response

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import uz.smartmuslim.ismlarmanosi.data.model.OfferStatus

data class OfferResponse(
    val id: Long,
    @SerializedName("name_id")
    val nameId: String,
    val desc: String,
    @SerializedName("offer_status")
    val offerStatus: OfferStatus,
    @SerializedName("created_date")
    val createdDate: String,
    @SerializedName("last_modified_date")
    val lastModifiedDate: String
)