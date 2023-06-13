package uz.smartmuslim.ismlarmanosi.data.repository.intro

import kotlinx.coroutines.flow.Flow


interface IntroRepository {

    fun setIsFirst(state: Boolean)

    fun getIsFirst(): Flow<Boolean>

    fun setIsFirstIntro(state: Boolean)

    fun getIsFirstIntro(): Flow<Boolean>

}