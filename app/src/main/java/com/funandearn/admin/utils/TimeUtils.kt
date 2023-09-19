package com.funandearn.admin.utils

import android.util.Log
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object TimeUtils {

    fun convertTimeToDisplayTime(timeInMillis: Long): String {
        return String.format(
            "%d:%d",
            TimeUnit.MILLISECONDS.toMinutes(timeInMillis),
            TimeUnit.MILLISECONDS.toSeconds(timeInMillis) -
                    TimeUnit.MINUTES.toSeconds((TimeUnit.MILLISECONDS.toMinutes(timeInMillis)))
        )
    }

    fun formatTime(dateStr: String, fortmatType: Int): String {

        // Converts the string
        // format to date object
        val d: DateFormat = SimpleDateFormat(dateStr)


        // Get the date using calendar object
        val today = Calendar.getInstance()
            .time

        // Return the result
        return d.format(today)
    }

    fun getCurrentDate():String{
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date =simpleDateFormat.format(Date())
        Log.d("TAG", "getCurrentDate: $date")
        return date;
    }

}