package com.wuhenzhizao.mvp

import kotlin.reflect.KClass

interface IBasePresenter {

    fun subscribe()

    fun unsubscribe()

    fun <M : IBaseModel> obtainModel(clazz: KClass<M>): M
}