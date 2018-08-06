package com.gome.common.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by liufei on 2017/10/11.
 */
object TimeUtils {
    private val EXTRA_TIME = "server_time"

    fun setSystemTime(serverTime: Long) {
        val difference = serverTime - System.currentTimeMillis()
        PreferenceUtils.setLong(EXTRA_TIME, difference)
    }

    @Synchronized fun getSystemTime(): Long {
        return System.currentTimeMillis() + PreferenceUtils.getLong(EXTRA_TIME, 0L)
    }

    fun getTime(time: Long, format: String): String {
        val simpleDateFormat = SimpleDateFormat(format)
        return simpleDateFormat.format(Date(time))
    }

    fun isTheSameDay(previousTime: Long, lastTime: Long): Boolean {
        val previousCalendar = Calendar.getInstance()
        previousCalendar.setTimeInMillis(previousTime)

        val lastCalendar = Calendar.getInstance()
        lastCalendar.setTimeInMillis(lastTime)

        return previousCalendar.get(Calendar.YEAR) === lastCalendar.get(Calendar.YEAR)
                && previousCalendar.get(Calendar.MONTH) === lastCalendar.get(Calendar.MONTH)
                && previousCalendar.get(Calendar.DAY_OF_MONTH) === lastCalendar.get(Calendar.DAY_OF_MONTH)
    }

    fun isToday(time: Long): Boolean {
        return isTheSameDay(time, getSystemTime())
    }

    fun getHourInDay(time: Long): Int {
        val calendar = Calendar.getInstance()
        calendar.setTimeInMillis(time)
        return calendar.get(Calendar.HOUR_OF_DAY)
    }

    /**
     * Z/ZZ/ZZZ: -0800
     * ZZZZ: GMT-08:00
     * ZZZZZ: -08:00
     */
    fun getCurrentTimezoneOffset(): String {
        return SimpleDateFormat("ZZZZZ", Locale.getDefault()).format(System.currentTimeMillis())
    }
}