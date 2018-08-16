package com.wuhenzhizao.mvp.net.intercepter

import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.wuhenzhizao.http.BaseIntercepter
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by liufei on 2017/10/11.
 */
internal class HeaderFileParamsIntercepter(context: Context) : BaseIntercepter(context) {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val builder = chain!!.request().newBuilder()
//        builder.header("Content-Type", "application/octet-stream")
//        builder.header("User-Id", PreferenceUtils.getString(GConstants.USER_ID, ""))
//        builder.header("Login-Token", PreferenceUtils.getString(GConstants.LOGIN_TOKEN, ""))

        val paramsBuilder = StringBuilder()

        val paramSize = publicParamList.size
        for (i in paramSize - 1 downTo 0) {
            val param = publicParamList[i]
            val key = param.key
            if (TextUtils.isEmpty(key)) continue
            builder.header(key, param.value)
            if (i == paramSize - 1) {
                paramsBuilder.append(key + " --> " + param.value)
            } else {
                paramsBuilder.append("\n" + key + " --> " + param.value)
            }
        }
        Log.d("api-header", paramsBuilder.toString())

        val request = builder.build()
        return chain.proceed(request)
    }


}