package br.com.projeto01.provaandroid

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.com.projeto01.provaandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {
            /* Valida se os campos de login estão preenchidos */
            var isValido = true

            if(binding.tieLogin.text.isNullOrEmpty()){
                isValido = false
                binding.tilLogin.error = "Preencha o login"
            }else{
                binding.tilLogin.error = null
            }

            if(binding.tieSenha.text.isNullOrEmpty()){
                isValido = false
                binding.tilSenha.error = "Preencha a senha"
            }else{
                binding.tilSenha.error = null
            }

            if(binding.tieConfirmarSenha.text.isNullOrEmpty()){
                isValido = false
                binding.tilConfirmarSenha.error = "Confirme a senha"
            }else{
                binding.tilConfirmarSenha.error = null
            }

            if(isValido){
                if(binding.tieSenha.text.toString().equals(binding.tieConfirmarSenha.text.toString())){
                    val intent = Intent(MainActivity@this, MainActivity2::class.java)
                    startActivity(intent)
                }else{
                    binding.tieConfirmarSenha.error = "As senhas devem ser iguais"
                }
            }
        }
    }
}