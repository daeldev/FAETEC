package br.com.projeto01.projetocep.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import br.com.projeto01.projetocep.modelo.Endereco
import br.com.projeto01.projetocep.repository.EnderecoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.HttpException

class EnderecoViewModel (private val enderecoRepository: EnderecoRepository): ViewModel(){
    val enderecoLiveData = MutableLiveData<Endereco>()
    val erroLiveData = MutableLiveData<String>()

    fun getEndereco(cep: String){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = async {
                    enderecoRepository.getEndereco(cep)
                }.await()
                if(response.isSuccessful){
                    enderecoLiveData.value = response.body()
                }else{
                    erroLiveData.value = "Não foi possível retornar o endereço"
                }
            }catch (http: HttpException){
                erroLiveData.value = "Erro na requisição: " + http.message()
            }catch (e: Exception){
                erroLiveData.value = "Erro genérico: " + e.message
            }
        }
        class EnderecoViewModelFactory(
            private val repository: EnderecoRepository
        ): ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return EnderecoViewModel(repository) as T
            }
        }
    }
}