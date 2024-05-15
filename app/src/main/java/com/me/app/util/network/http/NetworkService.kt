package com.me.app.util.network.http

import kotlin.reflect.KProperty

object NetworkService {

    private const val BASE_URL = "http://127.0.0.1:7500"

    val api by Service()

    class Service {
        operator fun getValue(thisRef: Any, property: KProperty<*>): Api {
            val hashMap :Map<String, String> ?= null

            return ApiFactory.createService(BASE_URL, Api::class.java, hashMap)
        }
    }

}