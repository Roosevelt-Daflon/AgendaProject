package com.example.progeto_agenda_contatos.controller

import android.util.Log
import com.example.progeto_agenda_contatos.modell.Contact
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.*

class ContactController
{


    companion object
    {
        private val db : FirebaseFirestore = FirebaseFirestore.getInstance()

        suspend fun addContact(contact: Contact)
        {
            val data = hashMapOf(
                "name" to contact.name,
                "phone" to contact.phone,
                "email" to contact.email)

            db.collection("contacts").add(data)
        }

        suspend fun getListContact(): ArrayList<Contact> {
            val list : ArrayList<Contact> = ArrayList()
            val res =   db.collection("contacts").get().addOnSuccessListener{}
            delay(3000L)
            for (c in res.result.documents)
            {
                list.add(Contact(
                    id = c.id,
                    name = c.data?.getValue("name") as String,
                    phone = c.data?.getValue("phone") as String,
                    email = c.data?.getValue("email") as String
                ))
            }
            return list
        }

        suspend fun deleteContact(id: String?)
        {
            if(id == null) return
            GlobalScope.launch(Dispatchers.IO) {
                runBlocking{
                    db.collection("contacts").document(id).delete()
                }
            }
        }

        suspend fun uptadeContact(id: String?, contact: Contact)
        {
            if (id == null) return

            var getContact : Contact? = null

            for (i in getListContact())
            {
                if(i.id == id){
                    getContact = i
                    break
                }
            }

            if(getContact == null) return

            if(contact.name != null) getContact.name = contact.name
            if(contact.phone != null) getContact.phone = contact.phone
            if(contact.email != null) getContact.email = contact.email

            GlobalScope.launch(Dispatchers.IO) {
                runBlocking{
                        db.collection("contacts").document(id).update(
                            "name", getContact.name,
                            "phone", getContact.phone,
                            "email", getContact.email)

                }
            }
        }

    }


}