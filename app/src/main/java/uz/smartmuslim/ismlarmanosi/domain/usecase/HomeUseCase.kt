package uz.smartmuslim.ismlarmanosi.domain.usecase

import kotlinx.coroutines.flow.Flow

interface HomeUseCase {

    fun getBoyNamesCount(): Flow<Int>

    fun getGirlNamesCount(): Flow<Int>
}