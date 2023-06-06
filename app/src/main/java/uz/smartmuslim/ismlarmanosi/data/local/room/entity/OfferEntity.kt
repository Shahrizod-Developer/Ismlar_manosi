package uz.smartmuslim.ismlarmanosi.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.smartmuslim.ismlarmanosi.data.model.OfferStatus

@Entity("offer_entity")
data class OfferEntity(

    @PrimaryKey(autoGenerate = false)
    val id: String,
    @ColumnInfo(name = "name_id")
    val nameId: String,
    val desc: String,
    @ColumnInfo(name = "offer_status")
    val offerStatus: OfferStatus,
    @ColumnInfo(name = "created_date")
    val createdDate: String,
    @ColumnInfo(name = "last_modified_date")
    val lastModifiedDate: String
)