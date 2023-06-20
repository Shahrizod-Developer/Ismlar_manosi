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

    @Query("Select * From name_entity")
    fun getAllName(): List<NameEntity>
    @Query("Select * From name_entity Where gender = 'MEN'")
    fun getAllBoyNames(): Flow<List<NameEntity>>

    @Query("Select * From name_entity Where gender = 'WOMEN'")
    fun getAllGirlNames(): Flow<List<NameEntity>>
    @Query("Select * From name_entity Where gender = 'MEN'")
    fun getAllBoysName(): List<NameEntity>

    @Query("Select * From name_entity Where gender = 'WOMEN'")
    fun getAllGirlsName(): List<NameEntity>

    @Query("DELETE FROM name_entity")
    fun deleteAll()

}