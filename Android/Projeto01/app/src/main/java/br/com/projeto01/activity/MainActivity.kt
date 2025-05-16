package br.com.projeto01.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.projeto01.activity.databinding.ActivityMainBinding
import br.com.projeto01.modelo.Usuario
import br.com.projeto01.util.Sessao

class MainActivity : AppCompatActivity() {
    // pega o layout e manda para o kt por um objeto declarado (imutável)

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        //Ação de clicar no btn "Entrar"
        binding.btnEntrar.setOnClickListener {
            var isValido = true

            //Valida se o login está preenchido
            if(binding.tieLogin.text.toString().isNullOrEmpty()){
                isValido = false
                binding.tillogin.error = getString(R.string.msg_campo_obrigatorio)
            }else{
                binding.tillogin.error = null
            }

            //Valida se a senha está preenchido
            if(binding.tieSenha.text.toString().isNullOrEmpty()){
                isValido = false
                binding.tilSenha.error = getString(R.string.msg_campo_obrigatorio)
            }else{
                binding.tilSenha.error = null
            }
            if(isValido){
                /*if(binding.tieLogin.text.toString().equals("admin") &&
                    binding.tieSenha.text.toString().equals("123")){

                    val intent = Intent(MainActivity@this, FormCadastroActivity::class.java)
                    startActivity(intent)
                }*/

                val usuario = Usuario(
                    idUsuario = null,
                    nome = null,
                    cpf = null,
                    dtNasc = null,
                    genero = null,
                    isTermoUso = null,
                    binding.tieLogin.text.toString(),
                    binding.tieSenha.text.toString()
                )

                Sessao.usuario = usuario
                val intent = Intent(MainActivity@this, HomeActivity::class.java)
                startActivity(intent)

                if(Sessao.usuario.nome.isNullOrEmpty()){

                }
            }
        }

        binding.tvCadastro.setOnClickListener {
            //Abrir nova tela
            val intent = Intent(MainActivity@this, FormCadastroActivity::class.java)
            startActivity(intent)
        }
    }
}