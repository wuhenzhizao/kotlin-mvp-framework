package com.wuhenzhizao.rxbus

import com.hwangjr.rxbus.Bus

object RxBus {
    private var bus: Bus = Bus()

    fun get() = bus
}