package com.me.app.util.network.http

import com.me.app.data.dto.LoginModel
import com.me.app.data.dto.Result
import com.me.app.data.entity.User
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("/user/login/account")
    suspend fun login(
        @Body loginReq: LoginModel
    ): Result<User>
}