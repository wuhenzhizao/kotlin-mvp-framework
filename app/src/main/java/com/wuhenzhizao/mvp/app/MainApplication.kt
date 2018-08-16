package com.wuhenzhizao.mvp.app

import com.wuhenzhizao.base.BaseApplication
import com.wuhenzhizao.image.ImageLoader
import com.wuhenzhizao.module.ModuleManager
import com.wuhenzhizao.mvp.net.ServiceFactory
import okhttp3.Interceptor

class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        ModuleManager.register(AppModule::class)
        ServiceFactory.init(this, "https://www.baidu.com", mutableListOf<Interceptor>())
        ImageLoader.init(ImageLoader.EngineType.Glide, this)
    }


    override fun onTerminate() {
        ImageLoader.release()
        super.onTerminate()
    }

}