package com.wuhenzhizao.base

import android.app.Activity
import android.os.Bundle
import com.trello.rxlifecycle2.components.RxFragment
import com.wuhenzhizao.mvp.IBasePresenter
import com.wuhenzhizao.mvp.IBaseView

abstract class BaseFragment : RxFragment(), IBaseView {
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

    override fun showProgressDialog(cancelable: Boolean) {

    }

    override fun dismissProgressDialog() {

    }

    override fun showToast(message: String) {

    }

    override fun startActivity(clazz: Class<Activity>, args: Bundle) {

    }

    override fun startActivityForResult(clazz: Class<Activity>, requestCode: Int, args: Bundle) {

    }

    override fun showSoftInputKeyBoard() {

    }

    override fun hideSoftInputKeyBoard() {

    }
}