package uz.smartmuslim.ismlarmanosi.data.model

import androidx.room.ColumnInfo

data class NameData(
    val id: String,
    val gender: Gender,
    val seenCount: Int,
    val likeCount: Int,
    val latinName: String,
    val latinDesc: String,
    val krillName: String,
    val krillDesc: String,
    val englishName: String,
    val englishDesc: String,
    val rukn: String,
)