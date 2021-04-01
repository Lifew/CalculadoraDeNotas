package com.example.calculadoradenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular = calcular
        val resultado = resultado


        btCalcular.setOnClickListener {
            val nota1:Double = nota1.text.toString().toDouble()
            val nota2:Double = nota2.text.toString().toDouble()
            val faltas:Int = Integer.parseInt(faltas.text.toString())
            val media:Double = (nota1 + nota2)/2

            if(nota1 < 0 || nota2 < 0 || faltas < 0 || nota1 > 10 || nota2 > 10){
                resultado.setText("Preencha os campos corretamente!")
                resultado.setTextColor(Color.RED)
            }else if(media < 6 && faltas > 10){
                resultado.setText("Aluno foi Reprovado por Nota e Faltas\nMédia Final: $media\nFaltas: $faltas")
                resultado.setTextColor(Color.RED)
            }else if(faltas > 10){
                resultado.setText("Aluno foi Reprovado por Faltas\nMédia Final: $media\nFaltas: $faltas")
                resultado.setTextColor(Color.RED)
            }else if(media < 6){
                resultado.setText("Aluno foi Reprovado por Nota\nMédia Final: $media\nFaltas: $faltas")
                resultado.setTextColor(Color.RED)
            }else{
                resultado.setText("Aluno foi Aprovado\nMédia Final: $media\nFaltas: $faltas")
                resultado.setTextColor(Color.GREEN)
            }

        }

    }
}