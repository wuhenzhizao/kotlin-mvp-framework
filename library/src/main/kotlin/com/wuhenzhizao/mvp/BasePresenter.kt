package com.wuhenzhizao.mvp

import com.wuhenzhizao.rxbus.RxBus
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlin.reflect.KClass

abstract class BasePresenter<V : IBaseView>(var view: V) : IBasePresenter {
    private lateinit var compositeDisposable: CompositeDisposable

    init {
        subscribe()
    }

    final override fun subscribe() {
        compositeDisposable = CompositeDisposable()
        RxBus.get().register(this)
    }

    final override fun unsubscribe() {
        compositeDisposable.clear()
        RxBus.get().unregister(this)
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun <M : IBaseModel> obtainModel(clazz: KClass<M>): M {
        return ModelManager.getModel(clazz)
    }
}