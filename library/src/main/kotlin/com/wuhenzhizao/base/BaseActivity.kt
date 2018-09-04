package com.wuhenzhizao.base

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import com.wuhenzhizao.mvp.IBasePresenter
import com.wuhenzhizao.mvp.IBaseView

abstract class BaseActivity : FragmentActivity(), IBaseView {
    private val presenterList: MutableList<IBasePresenter> = arrayListOf()

    protected fun addPresenter(p: IBasePresenter) {
        if (presenterList.contains(p)) {
            presenterList.remove(p)
        }
        presenterList.add(p)
    }

    override fun onDestroy() {
        for (p: IBasePresenter in presenterList) {
            p.unsubscribe()
        }
        super.onDestroy()
    }

    override fun getContext(): Context {
        return this
    }

    override fun showProgressDialog(cancelable: Boolean) {

    }

    override fun dismissProgressDialog() {

    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showSoftInputKeyBoard() {

    }

    override fun hideSoftInputKeyBoard() {

    }

    override fun postDelay(delayMillis: Long, block: () -> Unit) {
        window.decorView.postDelayed(block, delayMillis)
    }
}