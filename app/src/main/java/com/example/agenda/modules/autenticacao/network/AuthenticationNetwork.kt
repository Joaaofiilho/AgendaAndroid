package com.example.agenda.modules.autenticacao.network

import com.example.agenda.core.BaseNetwork
import com.example.agenda.modules.autenticacao.model.UserResponse
import com.example.agenda.modules.autenticacao.model.UserWrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AuthenticationNetwork : BaseNetwork() {

    private val API by lazy {
        getRetrofitBuilder().create(AuthenticationAPI::class.java)
    }

    fun requestLogin(
        email: String,
        password: String,
        onSucess: (response: Response<UserResponse>) -> Unit,
        onError: () -> Unit
    ) {
        val userWrapper = UserWrapper(email, password)

        API.requestLogin(userWrapper).enqueue(object: Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful) {
                    onSucess(response)
                } else {
                    onError()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                onError()
            }
        })
    }
}