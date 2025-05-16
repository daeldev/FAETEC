package br.com.projeto01.projetocep.repository

import br.com.projeto01.projetocep.modelo.Endereco
import br.com.projeto01.projetocep.service.EnderecoService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class EnderecoRepository (private val service: EnderecoService){
    suspend fun getEndereco(cep: String): Response<Endereco>{
        return withContext(Dispatchers.IO){
            service.getEndereco(cep)
        }
    }
}