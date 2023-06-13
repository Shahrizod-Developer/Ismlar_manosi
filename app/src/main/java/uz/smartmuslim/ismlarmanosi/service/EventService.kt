package uz.smartmuslim.ismlarmanosi.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import dagger.hilt.android.AndroidEntryPoint
import uz.smartmuslim.ismlarmanosi.MainActivity
import uz.smartmuslim.ismlarmanosi.R
import uz.smartmuslim.ismlarmanosi.broadcast.EventBroadcast


@AndroidEntryPoint
class EventService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    private var eventBroadcast: EventBroadcast? = null

    override fun onCreate() {
        super.onCreate()

        if (eventBroadcast == null) {
            eventBroadcast = EventBroadcast()
        }

        createChannel()
        val id = 123
        val notification = NotificationCompat.Builder(this, "Event").apply {
//            setSmallIcon(R.drawable.charging_svgrepo_com)
            setContentTitle("Event App")
            setContentText("This app listen events from System")
            setContentIntent(
                PendingIntent.getActivity(
                    this@EventService,
                    0,
                    Intent(this@EventService, MainActivity::class.java),
                    PendingIntent.FLAG_IMMUTABLE
                )
            )
        }.build()

        startForeground(id, notification)
        registerReceiver(eventBroadcast, IntentFilter().apply {
            addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
        }
        )
    }


    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                "Event",
                "Main",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager: NotificationManager =
                getSystemService(NotificationManager::class.java)

            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

}