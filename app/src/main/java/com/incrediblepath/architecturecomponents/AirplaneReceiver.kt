package com.incrediblepath.architecturecomponents

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AirplaneReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isEnabled = intent?.getBooleanExtra("state", false) ?: return
        if (isEnabled) {
            Log.e("ENABLED", "true")
        } else {
            Log.e("ENABLED", "false")
        }
    }
}