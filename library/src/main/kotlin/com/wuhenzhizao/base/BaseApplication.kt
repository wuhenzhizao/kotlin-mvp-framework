package com.wuhenzhizao.base

import android.support.multidex.MultiDexApplication
import com.squareup.leakcanary.LeakCanary

abstract class BaseApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }


}