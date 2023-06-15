package uz.smartmuslim.ismlarmanosi.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.ismlarmanosi.data.model.ChildrenCount

interface HomeUseCase {

    fun childrenNamesCount(): Flow<ChildrenCount>

    suspend fun syncNames()
}