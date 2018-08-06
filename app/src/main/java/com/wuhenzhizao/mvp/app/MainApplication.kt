package com.wuhenzhizao.mvp.app

import com.gome.common.net.ServiceFactory
import com.wuhenzhizao.base.BaseApplication
import com.wuhenzhizao.image.ImageLoader
import com.wuhenzhizao.module.ModuleManager

class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        ModuleManager.register(AppModule::class)
        ServiceFactory.init(this)
        ImageLoader.init(ImageLoader.EngineType.Glide,this)
    }


    override fun onTerminate() {
        ImageLoader.release()
        super.onTerminate()
    }

}