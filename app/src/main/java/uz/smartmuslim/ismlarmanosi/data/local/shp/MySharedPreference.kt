package uz.smartmuslim.ismlarmanosi.data.local.shp

import android.content.Context
import android.content.SharedPreferences
import uz.smartmuslim.ismlarmanosi.utils.SharedPreference
import javax.inject.Inject

class MySharedPreference @Inject constructor(
    context: Context,
    sharedPreferences: SharedPreferences
) : SharedPreference(context, sharedPreferences) {

    var isFirst: Boolean by Booleans(false)

    var isFirstIntro: Boolean by Booleans(false)

    var temp:Boolean by Booleans(true)
}