package uz.smartmuslim.ismlarmanosi.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.ImageEntity

@Dao
interface ImageDao : BaseDao<ImageEntity> {

    @Query("Select * From image_entity Where hash_id =:hashId")
    fun getImageByHashId(hashId: String): Flow<ImageEntity>
}