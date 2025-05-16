package com.example.revisaoprova

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.revisaoprova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //VAL IMUTAVEL
    //Binding manipular os componentes
    private val binding by lazy{
       ActivityMainBinding.inflate(layoutInflater) //Definir para pegar todos os id dos xmls
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

    binding.EntrarBtt.setOnClickListener {
        var validacao = true

        //  VALIDADOR USER
        if(binding.tieUser.text.toString().isNullOrEmpty()){   //Buscar o TIE = text, se ele é nulo
            validacao = false
            binding.tillUser.error = "Preencha os Campos"
        }else{
            binding.tillUser.error = null
        }

        //  VALIDADOR SENHA
        if(binding.tieSenha.text.toString().isNullOrEmpty()){   //Buscar o TIE = text, se ele é nulo
            validacao = false
            binding.tillSenha.error = "Preencha os Campos"
        }else{
            binding.tillSenha.error = null
        }


        if (validacao){
         val usuario = Usuario(
             binding.tieUser.text.toString(),
             binding.tieSenha.text.toString()
         )
            Sessao.usuario = usuario
            val proximaTela = Intent(MainActivity@this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    }
}