package uz.smartmuslim.ismlarmanosi.data.repository.name

import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.ismlarmanosi.data.model.ChildrenCount


interface NameRepository {

    fun childrenNamesCount(): Flow<ChildrenCount>

    suspend fun syncNames()
}