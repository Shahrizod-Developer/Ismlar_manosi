package uz.smartmuslim.ismlarmanosi.data.repository.name.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.NameDao
import uz.smartmuslim.ismlarmanosi.data.repository.name.NameRepository
import javax.inject.Inject

class NameRepositoryImpl @Inject constructor(
    private val dao: NameDao
) : NameRepository {
    override fun getBoyNamesCount(): Flow<Int> = flow {

        dao.getAllBoyNames().map {
            emit(it.size)
        }.collect()
    }

    override fun getGirlNamesCount(): Flow<Int> = flow {
        dao.getAllBoyNames().map {
            emit(it.size)
        }.collect()
    }
}