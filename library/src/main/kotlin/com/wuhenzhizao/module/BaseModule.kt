package com.wuhenzhizao.module

import com.wuhenzhizao.rxbus.RxBus

abstract class BaseModule : IBaseModule {

    init {
        subscribe()
    }

    final override fun subscribe() {
        super.subscribe()
        RxBus.get().register(this)
        onStart()
    }

    final override fun unsubscribe() {
        super.unsubscribe()
        RxBus.get().unregister(this)
        onStop()
    }

    abstract fun onStart()

    abstract fun onStop()
}