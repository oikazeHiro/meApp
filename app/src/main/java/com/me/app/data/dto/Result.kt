package com.me.app.data.dto


class Result<T> {
    val code = 200
    val msg = "success"
    val data: T? = null
}