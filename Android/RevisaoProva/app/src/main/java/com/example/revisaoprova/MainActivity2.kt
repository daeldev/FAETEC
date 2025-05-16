package com.example.revisaoprova

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.revisaoprova.databinding.ActivityMain2Binding
import com.example.revisaoprova.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        var valido = true
        val message = "Olá, Seja Bem vindo "
        if (Sessao.usuario.user.isNullOrEmpty()){
           valido = false
        }else{
            binding.tieExibirUser.setText(message + Sessao.usuario.user)
        }

        }

    }
