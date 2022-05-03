package com.example.progeto_agenda_contatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.progeto_agenda_contatos.adapter.ContactAdapter
import com.example.progeto_agenda_contatos.controller.ContactController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    var adapter: ContactAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val buttom = findViewById<FloatingActionButton>(R.id.add_button)

        val context = this
        runBlocking()
        {
            adapter = ContactAdapter(context, ContactController.getListContact())
            listView.adapter = adapter
        }

        buttom.setOnClickListener {
            val intent = Intent(this,RegiterActivity::class.java)

            finish()
            startActivity(intent)
        }

        listView.setOnItemClickListener{ parent, view, position, id ->

            val intent = Intent(this,ContactActivity::class.java)


            runBlocking {
                ContactActivity.indextContact = position
            }

            startActivity(intent)


        }

    }
}