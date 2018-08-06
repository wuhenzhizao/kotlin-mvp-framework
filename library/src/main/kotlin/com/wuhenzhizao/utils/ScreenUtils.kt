package com.gome.common.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.DisplayMetrics
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.wuhenzhizao.utils.AppUtils


/**
 * Created by liufei on 2017/10/11.
 */
object ScreenUtils {
    fun dp2px(context: Context?, dp: Float): Float {
        return if (context == null) -1.0f else dp * density(context)
    }

    fun px2dp(context: Context?, px: Float): Float {
        return if (context == null) -1.0f else px / density(context)
    }

    fun density(context: Context): Float {
        return context.getResources().getDisplayMetrics().density
    }

    fun dp2PxInt(context: Context, dp: Float): Int {
        return (dp2px(context, dp) + 0.5f).toInt()
    }

    fun px2DpInt(context: Context, px: Float): Float {
        return (px2dp(context, px) + 0.5f).toInt().toFloat()
    }

    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }

    fun px2sp(context: Context, pxValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

    fun getDisplayMetrics(context: Context): DisplayMetrics {
        val activity: Activity
        if (context !is Activity && context is ContextWrapper) {
            activity = context.baseContext as Activity
        } else {
            activity = context as Activity
        }

        val metrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(metrics)
        return metrics
    }

    fun getScreenPixelSize(context: Context): IntArray {
        val metrics = getDisplayMetrics(context)
        return intArrayOf(metrics.widthPixels, metrics.heightPixels)
    }

    fun hideSoftInputKeyBoard(context: Context) {
        val activity = AppUtils.getActivity(context)
        val focusView = activity!!.window.currentFocus
        if (focusView != null) {
            val binder = focusView!!.windowToken
            if (binder != null) {
                val imd = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imd.hideSoftInputFromWindow(binder, 1)
            }
        }
    }

    fun hideSoftInputKeyBoard(context: Context, focusView: View?) {
        if (focusView != null) {
            val binder = focusView!!.windowToken
            if (binder != null) {
                val imd = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imd.hideSoftInputFromWindow(binder, 1)
            }
        }
    }

    fun showSoftInputKeyBoard(context: Context, focusView: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(focusView, 2)
    }

    fun getScreenWidth(context: Context): Int {
        return context.resources.displayMetrics.widthPixels
    }

    fun getScreenHeight(context: Context): Int {
        return context.resources.displayMetrics.heightPixels
    }

    fun getStatusBarHeight(context: Context): Int {
        var statusBarHeight = 0
        try {
            var c = Class.forName("com.android.internal.R\$dimen")
            var obj = c!!.newInstance()
            var field = c.getField("status_bar_height")
            val x1 = Integer.parseInt(field!!.get(obj).toString())
            statusBarHeight = context.getResources().getDimensionPixelSize(x1)
        } catch (var7: Exception) {
            var7.printStackTrace()
        }
        return statusBarHeight
    }

    fun getAppInScreenheight(context: Context): Int {
        return getScreenHeight(context) - getStatusBarHeight(context)
    }
}