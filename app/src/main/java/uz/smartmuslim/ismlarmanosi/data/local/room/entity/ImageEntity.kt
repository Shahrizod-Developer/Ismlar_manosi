package uz.smartmuslim.ismlarmanosi.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.security.cert.Extension

@Entity("image_entity")
data class ImageEntity(

    @PrimaryKey(autoGenerate = false)
    val id: String,
    @ColumnInfo(name = "hash_id")
    val hashId: String,
    val name: String,
    @ColumnInfo(name = "file_size")
    val fileSize: String,
    @ColumnInfo(name = "content_type")
    val contentType: String,
    val extension: String,
    @ColumnInfo(name = "file_url")
    val fileUrl: String
)