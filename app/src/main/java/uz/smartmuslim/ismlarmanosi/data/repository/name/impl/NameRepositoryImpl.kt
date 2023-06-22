package uz.smartmuslim.ismlarmanosi.data.repository.name.impl

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.NameDao
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.NameEntity
import uz.smartmuslim.ismlarmanosi.data.local.shp.MySharedPreference
import uz.smartmuslim.ismlarmanosi.data.model.ChildrenCount
import uz.smartmuslim.ismlarmanosi.data.model.Gender
import uz.smartmuslim.ismlarmanosi.data.model.ListData
import uz.smartmuslim.ismlarmanosi.data.model.NameData
import uz.smartmuslim.ismlarmanosi.data.remote.api.NameApi
import uz.smartmuslim.ismlarmanosi.data.repository.name.NameRepository
import javax.inject.Inject

class NameRepositoryImpl @Inject constructor(
    private val dao: NameDao,
    private val api: NameApi,
    private val shp: MySharedPreference
) : NameRepository {

    override fun childrenNamesCount(): Flow<ChildrenCount> = flow {
        val childrenCount = ChildrenCount(0, 0)
        childrenCount.boyNamesCount = dao.getAllBoysName().size
        childrenCount.girlNamesCount = dao.getAllGirlsName().size
        emit(childrenCount)
    }.flowOn(Dispatchers.IO)

    override suspend fun syncNames() {
        try {
            val response = api.getAllNames()

            when (response.code()) {
                in 200..299 -> {
                    val names = response.body()
                    if (response.isSuccessful) {
                        if (shp.temp) {
                            names?.map {
                                dao.insert(it.toEntity())
                            }
                            shp.temp = false
                        } else {
                            names?.let {
                                val existingNames = dao.getAllName()

                                val updatedNames = mutableListOf<NameEntity>()
                                val deletedNames = mutableListOf<NameEntity>()
                                val newNames = mutableListOf<NameEntity>()

                                for (name in names) {
                                    val existingName = existingNames.find { it.id == name.id }
                                    if (existingName != null) {
                                        if (existingName.lastModifiedDate != name.lastModifiedDate) {
                                            val updatedName = existingName.copy(
                                                seenCount = name.seenCount,
                                                likeCount = name.likeCount,
                                                latinName = name.latinName,
                                                latinDesc = name.latinDesc,
                                                krillName = name.krillName,
                                                krillDesc = name.krillDesc,
                                                englishName = name.englishName,
                                                englishDesc = name.englishDesc,
                                                rukn = name.rukn,
                                                deleted = name.deleted,
                                                lastModifiedDate = name.lastModifiedDate
                                            )
                                            updatedNames.add(updatedName)
                                        }
                                    } else {
                                        newNames.add(name.toEntity())
                                    }
                                }

                                for (existingName in existingNames) {
                                    val deletedName = names.find { it.id == existingName.id }
                                    if (deletedName == null) {
                                        val updatedName = existingName.copy(deleted = true)
                                        deletedNames.add(updatedName)
                                    }
                                }

                                if (updatedNames.isNotEmpty()) {
                                    dao.update(updatedNames)
                                }

                                if (deletedNames.isNotEmpty()) {
                                    dao.delete(deletedNames)
                                }

                                if (newNames.isNotEmpty()) {
                                    dao.insert(newNames)
                                }
                            }
                        }
                    }

                }
            }
        } catch (e: Exception) {
            // Handle exception
            Log.d("TTT", "Handle exception = " + e.message)
        }
    }


    override fun getAllBoysName(): Flow<List<NameData>> = flow{
        dao.getAllBoyNames().map {
            emit(it.map { it.toData() })
        }.collect()
    }.flowOn(Dispatchers.IO)

    override fun getAllGirlsName(): Flow<List<NameData>> = flow{
        dao.getAllGirlNames().map {
            emit(it.map { it.toData() })
        }.collect()
    }.flowOn(Dispatchers.IO)

}