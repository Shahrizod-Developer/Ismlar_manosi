package uz.smartmuslim.ismlarmanosi.data.repository.name.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.NameDao
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.NameEntity
import uz.smartmuslim.ismlarmanosi.data.remote.api.NameApi
import uz.smartmuslim.ismlarmanosi.data.repository.name.NameRepository
import javax.inject.Inject

class NameRepositoryImpl @Inject constructor(
    private val dao: NameDao,
    private val api: NameApi
) : NameRepository {


    override fun getBoyNamesCount(): Flow<Int> {
        return dao.getAllBoyNames().map { it.size }
    }

    override fun getGirlNamesCount(): Flow<Int> {
        return dao.getAllGirlNames().map { it.size }
    }

   override suspend fun syncNames() {
        try {
            val response = api.getAllNames()

            when (response.code()) {
                in 200..299 -> {
                    if (response.isSuccessful) {
                        val names = response.body()
                        names?.let {
                            val existingNames = dao.getAllName()

                            val updatedNames = mutableListOf<NameEntity>()
                            val deletedNames = mutableListOf<NameEntity>()

                            for (name in names) {
                                val existingName = existingNames.find { it.id == name.id }
                                if (existingName != null) {
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
                                        createdDate = name.createdDate,
                                        lastModifiedDate = name.lastModifiedDate
                                    )
                                    updatedNames.add(updatedName)
                                } else {
                                    val newName = NameEntity(
                                        id = name.id,
                                        gender = name.gender,
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
                                        createdDate = name.createdDate,
                                        lastModifiedDate = name.lastModifiedDate
                                    )
                                    dao.insertIgnore(newName)
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
                                dao.update(deletedNames)
                            }
                        }
                    } else {
                        // Handle error
                    }
                }

                in 400..499 -> {
                    // Handle client-side error
                }

                in 500..599 -> {
                    // Handle server-side error
                }

                else -> {
                    // Handle other error cases
                }
            }
        } catch (e: Exception) {
            // Handle exception
        }
    }


}