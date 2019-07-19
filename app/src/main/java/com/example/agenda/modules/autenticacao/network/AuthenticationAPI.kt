package com.example.agenda.modules.autenticacao.network

import com.example.agenda.modules.autenticacao.model.UserResponse
import com.example.agenda.modules.autenticacao.model.UserWrapper
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationAPI {
    @POST("auth/sign_in")
    fun requestLogin(@Body user: UserWrapper) : Call<UserResponse>
}