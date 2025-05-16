package com.example.androidaula

import java.io.Serializable

data class Usuario(
    val login: String?, /* o "?" defini que a variável seja obrigatório */
    val senha: String?
):Serializable
