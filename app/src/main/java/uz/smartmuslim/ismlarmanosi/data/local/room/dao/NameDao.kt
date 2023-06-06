package uz.smartmuslim.ismlarmanosi.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.ArticleEntity
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.NameEntity


@Dao
interface NameDao : BaseDao<NameEntity> {

    @Query("Select * From name_entity")
    fun getAllNames(): Flow<List<NameEntity>>


    @Query("Select * From name_entity Where gender = 1")
    fun getAllBoyNames(): Flow<List<NameEntity>>

    @Query("Select * From name_entity Where gender = 2")
    fun getAllGirlNames(): Flow<List<NameEntity>>

}