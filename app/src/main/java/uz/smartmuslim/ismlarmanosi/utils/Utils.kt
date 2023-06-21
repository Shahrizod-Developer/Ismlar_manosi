package uz.smartmuslim.ismlarmanosi.utils

import timber.log.Timber

fun myLog(message : String, tag: String = "TTT") {
    Timber.tag(tag).d(message)
}
