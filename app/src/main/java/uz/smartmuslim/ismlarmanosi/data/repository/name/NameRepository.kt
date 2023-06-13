package uz.smartmuslim.ismlarmanosi.data.repository.name

import kotlinx.coroutines.flow.Flow


interface NameRepository {

    fun getBoyNamesCount(): Flow<Int>
    fun getGirlNamesCount(): Flow<Int>
}