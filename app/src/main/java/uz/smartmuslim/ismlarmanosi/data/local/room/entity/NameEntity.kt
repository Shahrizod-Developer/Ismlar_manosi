package uz.smartmuslim.ismlarmanosi.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import uz.smartmuslim.ismlarmanosi.data.model.Gender
import uz.smartmuslim.ismlarmanosi.data.model.NameData

@Entity(tableName = "name_entity")
data class NameEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val gender: Gender,
    @ColumnInfo(name = "seen_count")
    val seenCount: Int,
    @ColumnInfo(name = "like_count")
    val likeCount: Int,
    @ColumnInfo(name = "latin_name")
    val latinName: String?,
    @ColumnInfo(name = "latin_desc")
    val latinDesc: String?,
    @ColumnInfo(name = "krill_name")
    val krillName: String?,
    @ColumnInfo(name = "krill_desc")
    val krillDesc: String?,
    @ColumnInfo(name = "english_name")
    val englishName: String?,
    @ColumnInfo(name = "english_desc")
    val englishDesc: String?,
    val rukn: String?,
    @ColumnInfo("offer_count")
    val offerCount: Int? = null,
    val deleted: Boolean,
    @ColumnInfo(name = "created_date")
    val createdDate: String?,
    @ColumnInfo(name = "last_modified_date")
    val lastModifiedDate: String?
) {
    fun toData() = NameData(
        id,
        gender,
        seenCount,
        likeCount,
        latinName!!,
        latinDesc!!,
        krillName!!,
        krillDesc!!,
        englishName!!,
        englishDesc!!,
        rukn!!
    )
}
