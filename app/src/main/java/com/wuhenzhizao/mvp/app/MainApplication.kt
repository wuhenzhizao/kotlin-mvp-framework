package com.wuhenzhizao.mvp.app

import com.wuhenzhizao.base.BaseApplication
import com.wuhenzhizao.module.ModuleManager

class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        ModuleManager.register(AppModule::class)
    }
}