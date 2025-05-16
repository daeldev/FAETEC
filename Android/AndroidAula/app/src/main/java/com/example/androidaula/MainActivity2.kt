package com.example.androidaula

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidaula.databinding.ActivityMain2Binding
import com.example.androidaula.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy{
        ActivityMain2Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        var isValido = true

        if(Sessao.usuario.login.isNullOrEmpty()){
            isValido = false
        }else{
            binding.tieLogin.setText(Sessao.usuario.login)
        }

        if(Sessao.usuario.senha.isNullOrEmpty()){
            isValido = false
        }else{
            binding.tieSenha.setText(Sessao.usuario.senha)
        }

        binding.btnVoltar.setOnClickListener {
            val intent = Intent(MainActivity2@this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}