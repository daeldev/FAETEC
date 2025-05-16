package br.com.projeto01.modelo

import java.io.Serializable

data class Usuario(
    //Uma variável é obrigatória usando o "," após. Para não ser obrigatória, usa "?"
    val idUsuario: Int?,
    val nome: String?,
    val cpf: String?,
    val dtNasc: String?,
    val genero: Int?,
    val isTermoUso: Boolean?,
    val login: String?,
    val senha: String?
): Serializable
