package uz.smartmuslim.ismlarmanosi.data.remote.response

import com.google.gson.annotations.SerializedName
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.NameEntity
import uz.smartmuslim.ismlarmanosi.data.model.Gender

data class NameResponse(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("gender")
    val gender: String? = null,

    @SerializedName("seenCount")
    val seenCount: Int = 0,
    @SerializedName("likeCount")
    val likeCount: Int = 0,

    @SerializedName("latinName")
    val latinName: String? = null,

    @SerializedName("latinDesc")
    val latinDesc: String? = null,

    @SerializedName("krillName")
    val krillName: String? = null,

    @SerializedName("krillDesc")
    val krillDesc: String? = null,

    @SerializedName("englishName")
    val englishName: String? = null,

    @SerializedName("englishDesc")
    val englishDesc: String? = null,

    @SerializedName("rukn")
    val rukn: String? = null,

    @SerializedName("deleted")
    val deleted: Boolean = false,

    @SerializedName("createdDate")
    val createdDate: String? = null,

    @SerializedName("lastModifiedDate")
    val lastModifiedDate: String? = null
) {
    fun toEntity(): NameEntity {

        var sex = Gender.MEN
        if (gender.equals("WOMEN")) sex = Gender.WOMEN

        return NameEntity(
            id!!,
            sex,
            seenCount,
            likeCount,
            latinName,
            latinDesc,
            krillName,
            krillDesc,
            englishName,
            englishDesc,
            rukn,
            deleted,
            createdDate,
            lastModifiedDate
        )
    }

}