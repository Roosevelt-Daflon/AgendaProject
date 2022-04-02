package com.example.agendaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonSalvar = findViewById<Button>(R.id.salvarButton)
        val buttonBack = findViewById<Button>(R.id.voltarButton)

        buttonSalvar.setOnClickListener{

            val intent = Intent(this,MainActivity::class.java)

            val nomeText = findViewById<EditText>(R.id.editTextTextPersonName)
            val numeroText = findViewById<EditText>(R.id.editTextPhone)
            val emailText = findViewById<EditText>(R.id.editTextTextEmailAddress)

            if(nomeText.text.isNotEmpty() || numeroText.text.isNotEmpty() || emailText.text.isNotEmpty())
                MainActivity.contatos.add(Contato(nomeText.text.toString(), numeroText.text.toString(), emailText.text.toString()))

            finish()
            startActivity(intent)

        }

        buttonBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)

            finish()
            startActivity(intent)
        }
    }
}