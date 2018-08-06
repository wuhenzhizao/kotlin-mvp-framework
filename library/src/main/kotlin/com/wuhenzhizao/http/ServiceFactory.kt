package com.gome.common.net

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.ref.WeakReference


/**
 * Created by liufei on 2017/10/11.
 */
object ServiceFactory {
    private const val BASE_URL = ""
    private lateinit var context: WeakReference<Context>
    private lateinit var retrofit: Retrofit
    private lateinit var fileRetrofit: Retrofit

    fun init(context: Context?) {
        this.context = WeakReference(context!!.applicationContext)

        val builder = getRetrofitBuilder()
        builder.baseUrl(BASE_URL)
        builder.client(OkHttpClientFactory.newHttp(context))
        retrofit = builder.build()

        val fileBuilder = getRetrofitBuilder()
        fileBuilder.baseUrl(BASE_URL)
        fileBuilder.client(OkHttpClientFactory.newFile(context))
        fileRetrofit = fileBuilder.build()
    }

    private fun getRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(Gson()))
    }

    fun <T> getService(service: Class<T>): T = retrofit.create(service)

    fun <T> getFileUploadService(service: Class<T>): T = fileRetrofit.create(service)
}