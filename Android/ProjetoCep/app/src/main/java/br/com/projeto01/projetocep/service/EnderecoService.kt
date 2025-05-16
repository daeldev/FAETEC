package br.com.projeto01.projetocep.service

import br.com.projeto01.projetocep.modelo.Endereco
import retrofit2.Response
import retrofit2.http.Path
import retrofit2.http.GET

interface EnderecoService {

    @GET("ws/{cep}/json/")
    suspend fun getEndereco(@Path("cep") cep: String):Response<Endereco>
}