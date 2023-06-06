package uz.smartmuslim.ismlarmanosi.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.smartmuslim.ismlarmanosi.data.model.Gender

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
    val latinName: String,
    @ColumnInfo(name = "latin_desc")
    val latinDesc: String,
    @ColumnInfo(name = "krill_name")
    val krillName: String,
    @ColumnInfo(name = "krill_desc")
    val krillDesc: String,
    @ColumnInfo(name = "english_name")
    val englishName: String,
    @ColumnInfo(name = "english_desc")
    val englishDesc: String,
    val rukn: String,
    val deleted: Boolean,
    @ColumnInfo(name = "created_date")
    val createdDate: String,
    @ColumnInfo(name = "last_modified_date")
    val lastModifiedDate: String
)