package uz.smartmuslim.ismlarmanosi.data.repository.intro

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.smartmuslim.ismlarmanosi.data.local.shp.MySharedPreference
import uz.smartmuslim.ismlarmanosi.domain.repository.intro.IntroRepository
import javax.inject.Inject

class IntroRepositoryImpl @Inject constructor(
    private val mySharedPreference: MySharedPreference
) : IntroRepository {
    override fun setIsFirst(state: Boolean) {
        mySharedPreference.isFirst = true
    }

    override fun getIsFirst(): Flow<Boolean> = flow {
        emit(mySharedPreference.isFirst)
    }

    override fun setIsFirstIntro(state: Boolean) {
        mySharedPreference.isFirstIntro = true
    }

    override fun getIsFirstIntro(): Flow<Boolean> = flow {
        emit(mySharedPreference.isFirstIntro)
    }
}