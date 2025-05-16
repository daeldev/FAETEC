package br.com.projeto01.projetocep

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.projeto01.projetocep.databinding.ActivityMainBinding
import br.com.projeto01.projetocep.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivitySegundaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
    }
}