package uz.smartmuslim.ismlarmanosi.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.ismlarmanosi.data.model.NameData

interface NamesUseCase {

    fun getAllBoysName(): Flow<List<NameData>>

    fun getAllGirlsName(): Flow<List<NameData>>
}