package com.wuhenzhizao.http

/**
 * 服务请求异常
 */
class HttpException(code: Int, message: String, cause: Throwable?) : Exception(message, cause)