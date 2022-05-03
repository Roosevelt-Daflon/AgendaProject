package com.example.progeto_agenda_contatos

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.progeto_agenda_contatos.controller.ContactController
import com.example.progeto_agenda_contatos.modell.Contact
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.runBlocking


class ContactActivity : AppCompatActivity() {

    companion object
    {
        var indextContact : Int = 0
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val textName = findViewById<TextView>(R.id.textView_name)
        val textPhone = findViewById<TextView>(R.id.textView_phone)
        val textEmail = findViewById<TextView>(R.id.textView_Email)
        val backButton = findViewById<Button>(R.id.back_button)
        val deleteButton = findViewById<FloatingActionButton>(R.id.button_delete)
        val updateButton = findViewById<FloatingActionButton>(R.id.button_update)
        var contact : Contact

        runBlocking {
            contact =  ContactController.getListContact()[indextContact]
        }

        textName.text = "Nome: " + contact.name
        textPhone.text = "Telefone: " + contact.phone
        textEmail.text = "Email: " + contact.email

        backButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)
        }

        deleteButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)

            runBlocking {
                ContactController.deleteContact(contact.id)
            }

            finish()
            startActivity(intent)
        }

        updateButton.setOnClickListener{
            val intent = Intent(this,UpdateActivity::class.java)
            UpdateActivity.indextContact = indextContact
            finish()
            startActivity(intent)
        }


    }
}