package com.example.agendaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.widget.AdapterView

class MainActivity : AppCompatActivity() {

    companion object {
        val contatos : ArrayList<Contato> = ArrayList()
        var indexContato : Int = 0
    }

    var adapterC : ContatoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButtonObj = findViewById<FloatingActionButton>(R.id.AddButton)
        val listView = findViewById<ListView>(R.id.listView)

        adapterC = ContatoAdapter(this, contatos)

        listView.adapter = adapterC


        addButtonObj.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)

            finish()
            startActivity(intent)
        }

        listView.setOnItemClickListener{ parent, view, position, id ->
            indexContato = position
            val intent = Intent(this,ContatoActivity::class.java)

            finish()
            startActivity(intent)
        }

    }

}