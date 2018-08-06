package com.gome.common.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by liufei on 2017/10/11.
 */
object PreferenceUtils {
    private var preferences: SharedPreferences? = null
    private val NAME_SPACE = "GomeRetail"

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME_SPACE, Context.MODE_PRIVATE)
    }

    fun getString(key: String, defaultValue: String): String {
        return preferences!!.getString(key, defaultValue)
    }

    fun getString(key: String): String = getString(key, "")

    fun getBoolean(key: String, defaultValue: Boolean): Boolean =
            preferences!!.getBoolean(key, defaultValue)

    fun getBoolean(key: String): Boolean = getBoolean(key, false)

    fun getInt(key: String, defaultValue: Int): Int = preferences!!.getInt(key, defaultValue)

    fun getInt(key: String): Int = getInt(key, 0)

    private fun getFloat(key: String, defaultValue: Float): Float =
            preferences!!.getFloat(key, defaultValue)

    fun getFloat(key: String): Float = getFloat(key, 0.0f)

    fun getLong(key: String, defaultValue: Long): Long = preferences!!.getLong(key, defaultValue)

    fun getLong(key: String): Long = getLong(key, 0L)

    fun setString(key: String, value: String) {
        preferences!!.edit().putString(key, value).commit()
    }

    fun setBoolean(key: String, value: Boolean) {
        preferences!!.edit().putBoolean(key, value).commit()
    }

    fun setInt(key: String, value: Int) {
        preferences!!.edit().putInt(key, value).commit()
    }

    fun setFloat(key: String, value: Float) {
        preferences!!.edit().putFloat(key, value).commit()
    }

    fun setLong(key: String, value: Long) {
        preferences!!.edit().putLong(key, value).commit()
    }

    fun remove(key: String) {
        preferences!!.edit().remove(key).commit()
    }
}