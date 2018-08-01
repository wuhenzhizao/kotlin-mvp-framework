package com.wuhenzhizao.module

import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

object ModuleManager {
    private val moduleRefList: MutableList<IBaseModule> = mutableListOf()

    fun <M : IBaseModule> register(clazz: KClass<M>) {
        val module: M = clazz.createInstance()
        moduleRefList.add(module)
    }

    fun clear() {
        moduleRefList.forEach { module ->
            module.unsubscribe()
        }
        moduleRefList.clear()
    }
}