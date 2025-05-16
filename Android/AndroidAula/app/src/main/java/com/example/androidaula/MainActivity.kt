package com.example.androidaula

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidaula.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /* val é imutável */
    /* binding serve para manipular os componentes */
    private val binding by lazy{
        /* Seleciona a activity que será manipulada */
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /* .root serve para selecionar todos os componentes da activity */
        setContentView(binding.root)

        binding.btnConfirmar.setOnClickListener {
            /* Valida se os campos de login estão preenchidos */
            var isValido = true

            if(binding.tieLogin.text.isNullOrEmpty()){
                isValido = false
                binding.tilLogin.error = "Preencha o usuário"
            }else{
                binding.tilLogin.error = null
            }

            if(binding.tieSenha.text.isNullOrEmpty()){
                isValido = false
                binding.tilSenha.error = "Preencha a senha"
            }else{
                binding.tilSenha.error = null
            }

            if(isValido){
                val usuario = Usuario(
                    binding.tieLogin.text.toString(),
                    binding.tieSenha.text.toString()
                )
                Sessao.usuario = usuario
                val intent = Intent(MainActivity@this, MainActivity2::class.java)
                startActivity(intent)
            }
        }
    }
}