package uz.smartmuslim.ismlarmanosi.data.remote.response

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import uz.smartmuslim.ismlarmanosi.data.model.Gender

data class NameResponse(
    val id: String,
    val gender: Gender,
    @SerializedName("seen_count")
    val seenCount: Int,
    @SerializedName("like_count")
    val likeCount: Int,
    @SerializedName("latin_name")
    val latinName: String,
    @SerializedName("latin_desc")
    val latinDesc: String,
    @SerializedName("krill_name")
    val krillName: String,
    @SerializedName("krill_desc")
    val krillDesc: String,
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("english_desc")
    val englishDesc: String,
    val rukn: String,
    val deleted: Boolean,
    @SerializedName("created_date")
    val createdDate: String,
    @SerializedName("last_modified_date")
    val lastModifiedDate: String
)