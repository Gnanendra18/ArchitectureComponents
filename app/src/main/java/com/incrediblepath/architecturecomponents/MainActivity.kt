package com.incrediblepath.architecturecomponents

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var broadcastReceiver:AirplaneReceiver
    lateinit var myReceiver: MyReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        broadcastReceiver = AirplaneReceiver()
        registerReceiver(broadcastReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        myReceiver = MyReceiver()
        registerReceiver(myReceiver, IntentFilter("My_ACTION"))
        findViewById<TextView>(R.id.textview).setOnClickListener{
            sendBroadcast(Intent("My_ACTION"))
        }


    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
        unregisterReceiver(myReceiver)
    }
}