package com.android.myapplication

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.VpnService


/**
 * Create By Zwh On 2022/8/23
 */
class TestVpnService :VpnService() {
    override fun onCreate() {
        val ifConnectivity = IntentFilter()
        ifConnectivity.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
}