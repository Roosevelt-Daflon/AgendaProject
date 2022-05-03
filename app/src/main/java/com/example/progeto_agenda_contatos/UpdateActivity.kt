package com.example.progeto_agenda_contatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.progeto_agenda_contatos.controller.ContactController
import com.example.progeto_agenda_contatos.modell.Contact
import kotlinx.coroutines.runBlocking

class UpdateActivity : AppCompatActivity() {

    companion object
    {
        var indextContact : Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val nameText = findViewById<EditText>(R.id.nameText)
        val phoneText = findViewById<EditText>(R.id.phoneText)
        val emailText = findViewById<EditText>(R.id.emailText)
        val saveButton = findViewById<Button>(R.id.save_button)
        val backButton = findViewById<Button>(R.id.back_button)

        var contact : Contact

        runBlocking {
            contact =  ContactController.getListContact()[indextContact]
        }

        nameText.hint = contact.name
        phoneText.hint = contact.phone
        emailText.hint = contact.email

        saveButton.setOnClickListener {
            var contactTemp: Contact = Contact(contact.id, null, null, null)

            val intent = Intent(this,ContactActivity::class.java)
            if(nameText.text.isNotBlank())
            {
                contactTemp.name = nameText.text.toString()
            }

            if(phoneText.text.isNotBlank())
            {
                contactTemp.phone = phoneText.text.toString()
            }

            if(emailText.text.isNotBlank())
            {
                contactTemp.email = emailText.text.toString()
            }

            runBlocking {

                ContactController.uptadeContact(contact.id, contactTemp)
                finish()
                startActivity(intent)
            }

        }

        backButton.setOnClickListener {
            val intent = Intent(this,ContactActivity::class.java)
            ContactActivity.indextContact = indextContact
            finish()
            startActivity(intent)
        }



    }
}