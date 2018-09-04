package com.wuhenzhizao.mvp

import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

object ModelManager {
    private val modelMap: MutableMap<KClass<*>, IBaseModel> = mutableMapOf()

    fun <M : IBaseModel> getModel(clazz: KClass<M>): M {
        if (modelMap.containsKey(clazz)) {
            val model = modelMap[clazz] as IBaseModel
            model.apply {
                return model as M
            }
        }
        val model: M = clazz.createInstance()
        modelMap[clazz] = model
        return model
    }

    fun clear() {
        modelMap.forEach { _, value ->
            value.destroy()
        }
        modelMap.clear()
    }
}