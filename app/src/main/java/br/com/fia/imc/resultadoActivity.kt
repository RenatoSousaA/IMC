package br.com.fia.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_resultado.*

class resultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        calcular()
    }

    private fun calcular() {
        val peso = intent.getDoubleExtra("Peso", 0.0)
        val altura = intent.getDoubleExtra("Altura", 0.0)
        val sexo = intent.getStringExtra("Sexo") ?: getString(R.string.label_feminino)

        val imc = peso / (altura * altura)

        when (sexo) {
            getString(R.string.label_masculino) -> calcularMasculino(imc)
            getString(R.string.label_feminino) -> calcularFeminino(imc)
            else -> {
            }
        }

        tvIMC.text = imc.toFixed(1).toString()
    }

    private fun calcularMasculino(imc: Double) {
        if (imc < 20) {
            configuraImagem(R.drawable.masc_abaixo)
            tvStatusIMC.text = "Abaixo do peso"
        } else if (imc < 25) {
            configuraImagem(R.drawable.masc_ideal)
            tvStatusIMC.text = "Peso ideal"
        } else if (imc < 30) {
            configuraImagem(R.drawable.masc_sobre)
            tvStatusIMC.text = "Acima do Peso"
        } else if (imc < 43) {
            configuraImagem(R.drawable.masc_obeso)
            tvStatusIMC.text = "Obesidade"
        } else {
            configuraImagem(R.drawable.masc_extremo_obeso)
            tvStatusIMC.text = "Obesidade Extrema"
        }
    }

    private fun calcularFeminino(imc: Double) {
        if (imc < 19) {
            configuraImagem(R.drawable.fem_abaixo)
            tvStatusIMC.text = "Abaixo do peso"
        } else if (imc < 24) {
            configuraImagem(R.drawable.fem_ideal)
            tvStatusIMC.text = "Peso ideal"
        } else if (imc < 29) {
            configuraImagem(R.drawable.fem_sobre)
            tvStatusIMC.text = "Acima do Peso"
        } else if (imc < 39) {
            configuraImagem(R.drawable.fem_obeso)
            tvStatusIMC.text = "Obesidade"
        } else {
            configuraImagem(R.drawable.fem_extremo_obeso)
            tvStatusIMC.text = "Obesidade Extrema"
        }
    }

    private fun configuraImagem(resourceId: Int) {
        ivIMC.setImageDrawable(
            ContextCompat.getDrawable(this, resourceId)
        )
    }
}
