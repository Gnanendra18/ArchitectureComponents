package com.incrediblepath.architecturecomponents

import android.app.*
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationActivity : AppCompatActivity() {

    val NOTIFICATION_ID = 0
    val CHANNEL_ID = "some channel id"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        createNotificationChannel()


        val intent = Intent(this,MainActivity::class.java)
        val taskStack = TaskStackBuilder.create(this)
        taskStack.addNextIntentWithParentStack(intent)

        val pendingIntent = taskStack.getPendingIntent(0, PendingIntent.FLAG_IMMUTABLE)


        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        //val notificationManager = NotificationManagerCompat.from(this)
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Notification Title")
            .setContentText("THis is notification description")
            .setSmallIcon(R.drawable.notification_bar_image)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        findViewById<Button>(R.id.button).setOnClickListener{
            notificationManager.notify(NOTIFICATION_ID, notification)
        }




    }

    private fun createNotificationChannel() {
        val notificationManager = NotificationManagerCompat.from(this)
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            val notificationCompatChannel =
                NotificationChannel(
                    CHANNEL_ID,
                    "CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_DEFAULT
                )

            notificationManager.createNotificationChannel(notificationCompatChannel)
        }
    }
}