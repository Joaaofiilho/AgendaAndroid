package com.example.agenda.modules.autenticacao.business

import android.util.Patterns
import com.example.agenda.modules.autenticacao.network.AuthenticationNetwork

object AuthenticationBusiness {

    fun isEmailValid(email: String?) : Boolean {
        return !email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPasswordValid(password: String?) : Boolean {
        return !password.isNullOrBlank() && password.length == 8
    }

    fun doLogin(
        email: String,
        password: String,
        onSucess: () -> Unit,
        onError: () -> Unit
    ) {
        AuthenticationNetwork.requestLogin(email, password,
            onSucess = { response ->
                println("Sucesso!")
            },
            onError = {
                println("Falha!")
            })
    }
}