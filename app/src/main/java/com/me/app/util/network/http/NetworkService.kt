package com.me.app.util.network.http

import com.tencent.mmkv.MMKV
import kotlin.reflect.KProperty

object NetworkService {

    private const val BASE_URL = "http://10.18.12.235:7500"

    val api by Service()

    class Service {
        operator fun getValue(thisRef: Any, property: KProperty<*>): Api {
            var hashMap :Map<String, String> ?= null
            val mmkv = MMKV.defaultMMKV()
            val token = mmkv.decodeString("TOKEN")
            if (token.isNullOrEmpty()){
                hashMap = mutableMapOf()
                hashMap["Authorization"] = token.let {
                    "$it"
                }
            }
            return ApiFactory.createService(BASE_URL, Api::class.java, hashMap)
        }
    }

}

