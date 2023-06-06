package uz.smartmuslim.ismlarmanosi.data.remote.response

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class ImageResponse(
    val id: String,
    @SerializedName("hash_id")
    val hashId: String,
    val name: String,
    @SerializedName("file_size")
    val fileSize: String,
    @SerializedName("content_type")
    val contentType: String,
    val extension: String,
    @SerializedName("file_url")
    val fileUrl: String
)