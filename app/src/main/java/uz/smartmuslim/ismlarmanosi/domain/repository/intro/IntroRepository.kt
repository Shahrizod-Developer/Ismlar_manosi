package uz.smartmuslim.ismlarmanosi.domain.repository.intro

import kotlinx.coroutines.flow.Flow


interface IntroRepository {

    fun setIsFirst(state: Boolean)

    fun getIsFirst(): Flow<Boolean>

    fun setIsFirstIntro(state: Boolean)

    fun getIsFirstIntro(): Flow<Boolean>

}