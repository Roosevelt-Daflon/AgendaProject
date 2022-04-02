package com.example.agendaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ContatoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)

        findViewById<TextView>(R.id.textNome).text = "Nome: " + MainActivity.contatos[MainActivity.indexContato].nome
        findViewById<TextView>(R.id.textNumero).text = "Numero: " + MainActivity.contatos[MainActivity.indexContato].numero
        findViewById<TextView>(R.id.textEmail).text = "Email: " + MainActivity.contatos[MainActivity.indexContato].email

        var deletarButton = findViewById<FloatingActionButton>(R.id.Delete)
        var voltarButton = findViewById<FloatingActionButton>(R.id.Voltar)

        deletarButton.setOnClickListener {
            MainActivity.contatos.removeAt(MainActivity.indexContato)
            val intent = Intent(this,MainActivity::class.java)

            finish()
            startActivity(intent)
        }

        voltarButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)

            finish()
            startActivity(intent)
        }


    }
}