package br.com.projeto01.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.projeto01.activity.databinding.ActivityHomeBinding
import br.com.projeto01.util.Sessao

class HomeActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityHomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tieLogin2.setText(getString(R.string.str_bem_vindo) + ":" + Sessao.usuario.nome)
    }
}