package br.com.projeto01.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.projeto01.activity.databinding.ActivityFormCadastroBinding
import br.com.projeto01.modelo.Usuario
import br.com.projeto01.util.Sessao
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class FormCadastroActivity : AppCompatActivity() {

    companion object{
        private val GENERO_MASCULINO = 1
        private val GENERO_FEMININO = 2
        private val GENERO_OUTROS = 3
    }
    private var generoSelecionado: Int = 0

    private val binding by lazy {
        ActivityFormCadastroBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSalvar.setOnClickListener {
            var isValido = true

            if(binding.tieNome.text.toString().isNullOrEmpty()){
                isValido = false
                binding.tilNome.error = getString(R.string.msg_campo_obrigatorio)
            }else{
                binding.tilNome.error = null
            }

            if(binding.tieDataNasc.text.toString().isNullOrEmpty()){
                isValido = false
                binding.tilDataNasc.error = getString(R.string.msg_campo_obrigatorio)
            }else{
                binding.tilDataNasc.error = null
            }

            if(binding.tieCpf.text.toString().isNullOrEmpty()){
                isValido = false
                binding.tilCpf.error = getString(R.string.msg_campo_obrigatorio)
            }else{
                binding.tilCpf.error = null
            }

            if(!binding.cbTermos.isChecked){
                isValido = false
                binding.cbTermos.error = getString(R.string.msg_campo_obrigatorio)
            }else{
                binding.cbTermos.error = null
            }

            when(binding.rgGenero.checkedRadioButtonId){
                R.id.rbMasculino -> {
                    generoSelecionado = GENERO_MASCULINO
                }
                R.id.rbFeminino -> {
                    generoSelecionado = GENERO_FEMININO
                }
                R.id.rbOutros -> {
                    generoSelecionado = GENERO_OUTROS
                }
            }
            if(isValido){
                val usuario = Usuario(
                    idUsuario = null,
                    binding.tieNome.text.toString(),
                    binding.tieCpf.text.toString(),
                    binding.tieDataNasc.text.toString(),
                    generoSelecionado,
                    binding.cbTermos.isChecked,
                    login = null,
                    senha = null
                )
                Sessao.usuario = usuario

                val intent = Intent(FormCadastroActivity@this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        /*binding.tieDataNasc.setOnClickListener {
            showDatePickerDialog(binding.tieDataNasc)
        }*/

        binding.tilDataNasc.setEndIconOnClickListener {
            showDatePickerDialog(binding.tieDataNasc)
        }
    }
    private fun showDatePickerDialog(textInputEditText: TextInputEditText){
        val calendar = Calendar.getInstance()
        val ano = calendar.get(Calendar.YEAR)
        val mes = calendar.get(Calendar.MONTH)
        val dia = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            FormCadastroActivity@this,
            { _,anoSelecionado, mesSelecionado, diaSelecionado ->
                var mesStr = ""
                if(mesSelecionado < 10){
                    mesStr = "0" + (mesSelecionado+1).toString()
                }else{
                    mesStr = (mesSelecionado+1).toString()
                }
                val dataSelecionada = "$diaSelecionado/$mesStr/$anoSelecionado"
                textInputEditText.setText(dataSelecionada)
            },
            ano, mes, dia
        )
        datePickerDialog.show()
        }

}