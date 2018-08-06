package com.gome.common.net

import android.content.Context
import android.util.Log
import com.gome.common.net.intercepter.HeaderFileParamsIntercepter
import com.gome.common.net.intercepter.HeaderParamsIntercepter
import com.wuhenzhizao.mvp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by liufei on 2017/10/11.
 */
object OkHttpClientFactory {

    fun newHttp(context: Context): OkHttpClient =
            HttpFactoryWrapper(HttpFactory()).onCreate(context)

    fun newHttps(context: Context): OkHttpClient =
            HttpFactoryWrapper(HttpsFactory()).onCreate(context)

    fun newFile(context: Context): OkHttpClient =
            FileFactoryWrapper(HttpFactory()).onCreate(context)

    private abstract class Factory {

        fun onCreate(context: Context): OkHttpClient {
            var builder = OkHttpClient.Builder()
            buildOkHttpClient(context, builder)
            return builder.build()
        }

        abstract fun buildOkHttpClient(context: Context, builder: OkHttpClient.Builder)
    }

    private class HttpFactory : Factory() {

        override fun buildOkHttpClient(context: Context, builder: OkHttpClient.Builder) {

        }
    }

    private class HttpsFactory : Factory() {

        override fun buildOkHttpClient(context: Context, builder: OkHttpClient.Builder) {

        }
    }

    private open class FactoryWrapper(val factory: Factory) : Factory() {

        override fun buildOkHttpClient(context: Context, builder: OkHttpClient.Builder) {
            if (BuildConfig.DEBUG) {
                builder.addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                    Log.d("http",message)
                }).setLevel(HttpLoggingInterceptor.Level.BODY))
            }
            factory.buildOkHttpClient(context, builder)
        }
    }

    private class HttpFactoryWrapper(factory: Factory) : FactoryWrapper(factory) {

        override fun buildOkHttpClient(context: Context, builder: OkHttpClient.Builder) {
            super.buildOkHttpClient(context, builder)

            builder.addInterceptor(HeaderParamsIntercepter(context))
        }
    }

    private class FileFactoryWrapper(factory: Factory) : FactoryWrapper(factory) {

        override fun buildOkHttpClient(context: Context, builder: OkHttpClient.Builder) {
            super.buildOkHttpClient(context, builder)

            builder.addInterceptor(HeaderFileParamsIntercepter(context))
        }
    }
}