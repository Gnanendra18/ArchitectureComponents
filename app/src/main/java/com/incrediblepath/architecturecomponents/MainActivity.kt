package com.incrediblepath.architecturecomponents

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    val CHANNEL_ID = "some_channel_id"
    val CHANNEL_NAME = "some_channel_name"
    val NOTIFICATION_ID = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
        val notificationManager = NotificationManagerCompat.from(this)
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("ARGUMENT","SEND_TO_NOTIFICATION")
        getIntent().getStringExtra("ARGUMENT")?.let { Log.e("ARGUMENT", it) }
        val taskStack = TaskStackBuilder.create(this)
        taskStack.addNextIntentWithParentStack(intent)
        val pendingIntent = taskStack.getPendingIntent(0,PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("THis is title")
            .setContentText("This is discription")
            .setSmallIcon(R.drawable.notification_bar_image)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            //.setAutoCancel(true)
            .build()


        findViewById<TextView>(R.id.textview).setOnClickListener{
            notificationManager.notify(NOTIFICATION_ID,notification)
        }



    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            //create a notification channel
                val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT)
            channel.enableLights(true)
            channel.lightColor = Color.GREEN

            //val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val notificationManager = NotificationManagerCompat.from(this)
            notificationManager.createNotificationChannel(channel)

        }
    }


}