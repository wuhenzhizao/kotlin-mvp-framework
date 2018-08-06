package com.wuhenzhizao.mvp

import java.lang.ref.SoftReference
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

object ModelManager {
    private val modelRefMap: MutableMap<KClass<*>, SoftReference<*>> = mutableMapOf()

    @Suppress("UNCHECKED_CAST")
    fun <M : IBaseModel> getModel(clazz: KClass<M>): M {
        if (modelRefMap.containsKey(clazz)) {
            val modelRef: SoftReference<IBaseModel> = modelRefMap[clazz] as SoftReference<IBaseModel>
            modelRef.apply {
                if (!modelRef.isEnqueued&& modelRef.get() != null) {
                    return modelRef.get() as M
                } else {
                    modelRefMap.remove(clazz)
                }
            }
        }
        val model: M = clazz.createInstance()
        modelRefMap[clazz] = SoftReference(model)
        return model
    }

    fun clear() {
        modelRefMap.forEach { _, value ->
            if (!value.isEnqueued) {
                val model = value.get() as IBaseModel
                model.destroy()
                value.enqueue()
            }
        }
        modelRefMap.clear()
    }
}