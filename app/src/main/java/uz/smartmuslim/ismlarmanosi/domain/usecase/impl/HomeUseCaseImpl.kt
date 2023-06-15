package uz.smartmuslim.ismlarmanosi.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.ismlarmanosi.data.model.ChildrenCount
import uz.smartmuslim.ismlarmanosi.data.repository.name.NameRepository
import uz.smartmuslim.ismlarmanosi.domain.usecase.HomeUseCase
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
    private val repository: NameRepository
) : HomeUseCase {
    override fun childrenNamesCount(): Flow<ChildrenCount> = repository.childrenNamesCount()


    override suspend fun syncNames() = repository.syncNames()
}