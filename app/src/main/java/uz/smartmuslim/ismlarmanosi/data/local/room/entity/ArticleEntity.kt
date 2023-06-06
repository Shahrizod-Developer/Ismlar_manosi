package uz.smartmuslim.ismlarmanosi.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity("article_entity")
data class ArticleEntity(

    @PrimaryKey(autoGenerate = false)
    val id: String,
    @ColumnInfo(name = "image_hash_id")
    val imageHashId: String,
    val title: String,
    val desc: String,
    val text: String,
    val author: String,
    val deleted: Boolean,
    @ColumnInfo(name = "created_date")
    val createdDate: String,
    @ColumnInfo(name = "last_modified_date")
    val lastModifiedDate: String
)