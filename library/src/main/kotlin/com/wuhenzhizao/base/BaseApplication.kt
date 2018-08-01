package com.wuhenzhizao.base

import android.support.multidex.MultiDexApplication
import com.squareup.leakcanary.LeakCanary
import com.wuhenzhizao.module.ModuleManager
import com.wuhenzhizao.mvp.ModelManager

abstract class BaseApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    override fun onTerminate() {
        ModelManager.clear()
        ModuleManager.clear()
        super.onTerminate()
    }
}