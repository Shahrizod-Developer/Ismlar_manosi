package uz.smartmuslim.ismlarmanosi.broadcast

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.speech.tts.TextToSpeech
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.smartmuslim.ismlarmanosi.data.repository.name.NameRepository
import java.util.Locale
import javax.inject.Inject
//
//@AndroidEntryPoint
//class EventBroadcast : BroadcastReceiver() {
//
//    @Inject
//    lateinit var nameRepository: NameRepository
//
//    override fun onReceive(context: Context?, intent: Intent?) {
//        when (intent?.action) {
//            ConnectivityManager.CONNECTIVITY_ACTION -> {
//
//                val connectivityManager =
//                    context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//                val networkInfo = connectivityManager.activeNetworkInfo
//
//                if (networkInfo?.isConnected == true) {
//                    val isWiFi = networkInfo.type == ConnectivityManager.TYPE_WIFI
//                    val isMobile = networkInfo.type == ConnectivityManager.TYPE_MOBILE
//
//                    if (isWiFi || isMobile) {
//                        CoroutineScope(Dispatchers.IO).launch {
//                            Log.d("TTT", "syncNames")
//                            nameRepository.syncNames()
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
