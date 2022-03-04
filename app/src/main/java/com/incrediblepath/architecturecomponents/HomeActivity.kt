package com.incrediblepath.architecturecomponents

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    lateinit var receiver: AirplaneReceiver
    var state:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.send_event).setOnClickListener{
            val intent = Intent("MY_ACTION")
            state = !state
            intent.putExtra("state",state)
            sendBroadcast(intent)
        }



        val filter = IntentFilter("MY_ACTION")
        receiver = AirplaneReceiver()
        registerReceiver(receiver,filter)



    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}