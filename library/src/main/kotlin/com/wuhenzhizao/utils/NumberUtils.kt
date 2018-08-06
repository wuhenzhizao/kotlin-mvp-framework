package com.gome.common.utils

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * Created by liufei on 2017/10/13.
 */
object NumberUtils {

    fun formatNumber(value: Double): String = String.format("%.2f", value)

    fun formatNumber(value: BigDecimal): String = String.format("%.2f", value)

    private fun formatNumber(value: Any?, pattern: String): String {
        return if (value != null) {
            DecimalFormat(pattern).format(value)
        } else ""
    }

    fun formatNumberReturnInteger(value: Any?, pattern: String) = if (value != null) {
            Integer.valueOf(formatNumber(value, pattern))!!
        } else 0

    fun formatNumberReturnDouble(value: Any?, pattern: String): Double {
        if (value != null) {
            val format = DecimalFormat(pattern)
            format.roundingMode = RoundingMode.HALF_UP
            return java.lang.Double.valueOf(format.format(value))
        }
        return 0.0
    }
}