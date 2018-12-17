package com.yurentsy.swapi.utils

import android.content.Context
import android.net.ConnectivityManager
import com.yurentsy.swapi.App

object NetworkStatus {
    fun getStatus(): Status {
        val cm =
            App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        activeNetwork?.let { networkInfo ->
            return when (networkInfo.type) {
                ConnectivityManager.TYPE_WIFI -> Status.WIFI
                ConnectivityManager.TYPE_ETHERNET -> Status.ETHERNET
                ConnectivityManager.TYPE_MOBILE -> Status.MOBILE
                else -> Status.OFFLINE
            }
        }
        return Status.OFFLINE
    }

    fun isOnline(): Boolean = getStatus() != Status.OFFLINE

    enum class Status {
        WIFI,
        MOBILE,
        ETHERNET,
        OFFLINE
    }
}