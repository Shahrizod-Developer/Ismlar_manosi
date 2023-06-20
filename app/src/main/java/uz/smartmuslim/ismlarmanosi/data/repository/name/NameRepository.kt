package uz.smartmuslim.ismlarmanosi.data.repository.name

import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.ismlarmanosi.data.model.ChildrenCount
import uz.smartmuslim.ismlarmanosi.data.model.NameData


interface NameRepository {

    fun childrenNamesCount(): Flow<ChildrenCount>

    suspend fun syncNames()

    fun getAllBoysName(): Flow<List<NameData>>
    fun getAllGirlsName(): Flow<List<NameData>>
}