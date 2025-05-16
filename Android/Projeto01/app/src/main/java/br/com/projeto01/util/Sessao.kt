package br.com.projeto01.util

import br.com.projeto01.modelo.Usuario

class Sessao {
    companion object{
        //Permite ao usuario que incialize o var quando quiser, o sistema não reclamará
        lateinit var usuario: Usuario
    }
}