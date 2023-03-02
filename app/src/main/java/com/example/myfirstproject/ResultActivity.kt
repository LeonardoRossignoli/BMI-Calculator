package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resoult)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvresult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)


        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvresult.text = result.toString()

        var classificacao = ""
        if (result < 18.5) {
            classificacao = "Abaixo do peso"
        } else if (result in 18.5..24.9) {
            classificacao = "Normal"
        } else if (result in 25.0..29.9) {
            classificacao = "Sobrepeso "
        } else if (result in 30.0..39.9) {
            classificacao = "Obrsidade I"
        } else if (result >= 40.0) {
            classificacao = "Obesidade grave II"

        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)


    }

}