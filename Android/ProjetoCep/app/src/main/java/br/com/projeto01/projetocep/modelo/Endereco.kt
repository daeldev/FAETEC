package br.com.projeto01.projetocep.modelo

import java.io.Serializable

data class Endereco(
    val cep: String,
    val uf: String,
    val localidade: String,
    val bairro: String,
    val logradouro: String,
    val numero: String
): Serializable