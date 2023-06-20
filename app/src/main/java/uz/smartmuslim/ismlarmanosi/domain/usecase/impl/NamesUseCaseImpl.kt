package uz.smartmuslim.ismlarmanosi.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.ismlarmanosi.data.model.NameData
import uz.smartmuslim.ismlarmanosi.data.repository.name.NameRepository
import uz.smartmuslim.ismlarmanosi.domain.usecase.NamesUseCase
import javax.inject.Inject

class NamesUseCaseImpl @Inject constructor(
    private val repository: NameRepository
) : NamesUseCase {
    override fun getAllBoysName(): Flow<List<NameData>> = repository.getAllBoysName()

    override fun getAllGirlsName(): Flow<List<NameData>> = repository.getAllGirlsName()
}