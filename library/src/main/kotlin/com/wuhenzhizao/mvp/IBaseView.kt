package com.wuhenzhizao.mvp

import android.app.Activity
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
    fun startActivity(clazz: Class<Activity>, args: Bundle)

    /**
     * 启动Activity
     */
    fun startActivityForResult(clazz: Class<Activity>, requestCode: Int, args: Bundle)

    /**
     * 显示键盘
     */
    fun showSoftInputKeyBoard()

    /**
     * 隐藏键盘
     */
    fun hideSoftInputKeyBoard()
}