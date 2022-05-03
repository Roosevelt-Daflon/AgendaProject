package com.example.progeto_agenda_contatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.progeto_agenda_contatos.controller.ContactController
import com.example.progeto_agenda_contatos.modell.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegiterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regiter)

        val nameText = findViewById<EditText>(R.id.nameText)
        val phoneText = findViewById<EditText>(R.id.phoneText)
        val emailText = findViewById<EditText>(R.id.emailText)
        val saveButton = findViewById<Button>(R.id.save_button)
        val backButton = findViewById<Button>(R.id.back_button)

        saveButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            if(nameText.text.count() > 0 && phoneText.text.count() > 0 && emailText.text.count() > 0)
            {
                GlobalScope.launch(Dispatchers.IO)
                {
                    ContactController.addContact(Contact(
                        null,
                        nameText.text.toString(),
                        phoneText.text.toString(),
                        emailText.text.toString()))


                }
            }

            finish()
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)
        }

    }
}