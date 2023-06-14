package uz.smartmuslim.ismlarmanosi.data.repository.name.impl

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.NameDao
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.NameEntity
import uz.smartmuslim.ismlarmanosi.data.local.shp.MySharedPreference
import uz.smartmuslim.ismlarmanosi.data.model.Gender
import uz.smartmuslim.ismlarmanosi.data.remote.api.NameApi
import uz.smartmuslim.ismlarmanosi.data.repository.name.NameRepository
import javax.inject.Inject

class NameRepositoryImpl @Inject constructor(
    private val dao: NameDao,
    private val api: NameApi,
    private val shp:MySharedPreference
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

                    if (response.isSuccessful){
                        if (shp.temp){
                            response.body()?.map {
                                dao.insert(it.toEntity())
                            }
                        }else{

                        }
                    }

                }
            }
        } catch (e: Exception) {
            // Handle exception
            Log.d("TTT", "Handle exception = " + e.message)
        }
    }


}