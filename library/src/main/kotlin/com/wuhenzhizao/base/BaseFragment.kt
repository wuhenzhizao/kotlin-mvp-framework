package com.wuhenzhizao.base

import android.content.Context
import android.support.v4.app.Fragment
import com.wuhenzhizao.mvp.IBasePresenter
import com.wuhenzhizao.mvp.IBaseView

abstract class BaseFragment : Fragment(), IBaseView {
    private val presenterList: MutableList<IBasePresenter> = arrayListOf()

    protected fun addPresenter(p: IBasePresenter) {
        if (presenterList.contains(p)) {
            presenterList.remove(p)
        }
        presenterList.add(p)
    }

    override fun onDestroy() {
        for (p: IBasePresenter in presenterList) {
            p.subscribe()
        }
        super.onDestroy()
    }

    override fun getContext(): Context {
        return super.getContext()!!
    }

    override fun showProgressDialog(cancelable: Boolean) {

    }

    override fun dismissProgressDialog() {

    }

    override fun showToast(message: String) {

    }

    override fun showSoftInputKeyBoard() {

    }

    override fun hideSoftInputKeyBoard() {

    }

    override fun postDelay(delayMillis: Long, block: () -> Unit) {
        view?.postDelayed(block, delayMillis)
    }
}