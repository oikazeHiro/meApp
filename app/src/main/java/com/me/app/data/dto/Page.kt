package com.me.app.data.dto


open class Page<T> {
    val records: List<T>? = null
    val total: Long = 0
    val size: Long = 0
    val current: Long = 0
    val orders: List<OrderItem>? = null
    val optimizeCountSql = false
    val searchCount = false
    val optimizeJoinOfCountSql = false
    val maxLimit: Long? = null
    val countId: String? = null
    val obj: T? = null
    val other: Map<String, String>? = null
}