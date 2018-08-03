package com.wuhenzhizao.mvp

import android.app.Activity
import android.content.Intent
import android.os.Bundle

interface IBaseView {

    fun getActivity(): Activity

    /**
     * 显示进度条
     */
    fun showProgressDialog(cancelable: Boolean)

    /**
     * 隐藏进度条
     */
    fun dismissProgressDialog()

    /**
     * Toast提醒
     */
    fun showToast(message: String)

    /**
     * 启动Activity
     */
    fun startActivity(intent:Intent)

    /**
     * 启动Activity
     */
    fun startActivityForResult(intent:Intent, requestCode: Int)

    /**
     * 显示键盘
     */
    fun showSoftInputKeyBoard()

    /**
     * 隐藏键盘
     */
    fun hideSoftInputKeyBoard()
}