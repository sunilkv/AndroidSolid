package com.funandearn.admin.utils

import android.util.Log
import java.util.Objects

object LogUtil {

    public fun log(TAG : String, logType : String, msg: String) : String{

        when(logType){
            "w" -> {
                Log.w(TAG, "log: $msg")
            }
            "e" -> {
                Log.e(TAG, "log: $msg")
            }
            "i" -> {
                Log.i(TAG, "log: $msg")
            }
             else -> {
                Log.d(TAG, "log: $msg")
            }
        }
        return  "";
    }
}