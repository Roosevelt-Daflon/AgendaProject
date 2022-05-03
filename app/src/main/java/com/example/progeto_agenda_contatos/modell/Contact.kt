package com.example.progeto_agenda_contatos.modell

class Contact(val id: String?, var name: String?, var phone: String?, var email: String?)
{
    override fun toString(): String {
        return "Contact(id='$id', name='$name', phone='$phone', email='$email')"
    }
}