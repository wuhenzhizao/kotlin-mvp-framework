package com.wuhenzhizao.http

import android.content.Context
import okhttp3.Interceptor

/**
 * Created by liufei on 2017/10/11.
 */
class PublicParam(val key: String, val value: String)

abstract class BaseIntercepter : Interceptor {
    protected val publicParamList: MutableList<PublicParam> = arrayListOf()
    protected var context: Context? = null

    constructor(context: Context) {
        this.context = context.applicationContext

        if (publicParamList.size == 0) {
//            publicParamList!!.add(PublicParam("X-Gomeplus-Access-Token", ""))
//
//            // 设备唯一ID（对于iOS：多次重装app也保持不变）(待确认)
//            val device = StringBuilder()
//            var imei = TelephoneUtils.getIMEI(context)
//            if (TextUtils.isEmpty(imei)) {
//                imei = TelephoneUtils.getPhoneUUID(context)
//            }
//            device.append("Android")
//                    .append("/" + filterVisibleAscii(Build.VERSION.RELEASE))
//                    .append("/" + filterVisibleAscii(Build.MODEL))
//                    .append("/" + imei)
//            publicParamList.add(PublicParam("X-Gomeplus-Device", device.toString()))
//
//            // {AppId}/{From}
//            // AppId	iOS: 001 Android: 002 Wap: 003 H5：004 PC：005
//            var channelId = TelephoneUtils.getMetaData(context, "FROM")
//            channelId = channelId.substring(1, channelId.length - 1)
//            val app = StringBuilder()
//            app.append("002").append("/" + channelId)
//            publicParamList.add(PublicParam("X-Gomeplus-App", app.toString()))
//
//            publicParamList.add(PublicParam("X-Gomeplus-Net", TelephoneUtils.getNetworkName(context)))
//
//            // X-Gomeplus-Lang
//            publicParamList.add(PublicParam("X-Gomeplus-Lang", Locale.getDefault().language))
//            // 时区，格式为 "±[hh]:[mm]"，例如印度时间：+05:30
//            publicParamList.add(PublicParam("X-Gomeplus-Time-Zone", TimeUtils.getCurrentTimezoneOffset()))
//            publicParamList.add(PublicParam("X-Gomeplus-Region", Locale.getDefault().country))
//
//            publicParamList.add(PublicParam("Accept", "application/json"))
//            publicParamList.add(PublicParam("X-Gomeplus-App-Version", TelephoneUtils.getVersionName(context)))
        }
    }

    protected fun filterVisibleAscii(string: String): String {
        val stringBuffer = StringBuffer()
        var i = 0
        val length = string.length
        while (i < length) {
            val c = string[i]
            if (c <= '\u001f' || c >= '\u007f') {
                stringBuffer.append(String.format("\\u%04x", c.toInt()))
            } else {
                stringBuffer.append(c)
            }
            i++
        }
        return stringBuffer.toString()
    }
}