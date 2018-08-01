package com.wuhenzhizao.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V : IBaseView>(var view: V) : IBasePresenter {
    private lateinit var compositeDisposable: CompositeDisposable

    init {
        subscribe()
    }

    final override fun subscribe() {
        compositeDisposable = CompositeDisposable()

    }

    final override fun unsubscribe() {
        compositeDisposable.clear()
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun <M : IBaseModel> obtainModel(clazz: Class<M>): M? {
        return null
    }
}