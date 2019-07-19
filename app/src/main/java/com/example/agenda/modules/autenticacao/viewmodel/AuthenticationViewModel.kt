package com.example.agenda.modules.autenticacao.viewmodel

import com.example.agenda.core.viewmodel.BaseViewModel
import com.example.agenda.modules.autenticacao.business.AuthenticationBusiness

class AuthenticationViewModel : BaseViewModel() {

    fun login(email: String?, password: String?) {
        if(!AuthenticationBusiness.isEmailValid(email)) {
            onError.value = "Email inválido"
            return
        }


        if(!AuthenticationBusiness.isPasswordValid(password)) {
            onError.value = "Senha inválida"
        }


        AuthenticationBusiness.doLogin(email!!, password!!,
            onSucess = {

            },
            onError = {

            })
    }
}