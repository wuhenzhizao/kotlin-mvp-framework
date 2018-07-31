package com.wuhenzhizao.mvp

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : IBaseView>(var view: V) : IBasePresenter {
    private lateinit var disposable: CompositeDisposable

    init {
        subscribe()
    }

    final override fun subscribe() {
        disposable = CompositeDisposable()
    }

    final override fun unsubscribe() {
        disposable.clear()
    }
}