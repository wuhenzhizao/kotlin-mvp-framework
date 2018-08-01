package com.wuhenzhizao.mvp

interface IBasePresenter {

    fun subscribe()

    fun unsubscribe()

    fun <M : IBaseModel> obtainModel(clazz: Class<M>): M?
}