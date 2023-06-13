package uz.smartmuslim.ismlarmanosi.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.ismlarmanosi.data.repository.name.NameRepository
import uz.smartmuslim.ismlarmanosi.domain.usecase.HomeUseCase
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home.HomeScreenViewModel
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
    private val repository: NameRepository
) : HomeUseCase {
    override fun getBoyNamesCount(): Flow<Int> = repository.getBoyNamesCount()

    override fun getGirlNamesCount(): Flow<Int> = repository.getGirlNamesCount()
}