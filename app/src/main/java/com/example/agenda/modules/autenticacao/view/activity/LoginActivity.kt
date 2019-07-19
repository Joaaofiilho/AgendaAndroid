package com.example.agenda.modules.autenticacao.view.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.agenda.R
import com.example.agenda.core.view.activity.BaseActivity
import com.example.agenda.modules.autenticacao.viewmodel.AuthenticationViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.design.snackbar

class LoginActivity : BaseActivity() {

    private lateinit var authenticationViewModel: AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        authenticationViewModel = ViewModelProviders.of(this).get(AuthenticationViewModel::class.java)

        setupView()
        subscribeUI()
    }

    fun setupView() {

        buttonLogin.setOnClickListener {
            authenticationViewModel.login(fieldEmail.editText?.text.toString(),
                fieldPassword.editText?.text.toString())
        }∂
    }

    fun subscribeUI() {
        with (authenticationViewModel) {
            onError.observe(this@LoginActivity, Observer { message ->
                container.snackbar(message)
            })
        }
    }
}