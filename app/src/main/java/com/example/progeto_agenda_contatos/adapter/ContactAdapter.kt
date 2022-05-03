package com.example.progeto_agenda_contatos.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.progeto_agenda_contatos.R
import com.example.progeto_agenda_contatos.modell.Contact

class ContactAdapter(private val context: Context, private val arrayList: java.util.ArrayList<Contact>) : BaseAdapter()
{
    private lateinit var name : TextView

    override fun getCount(): Int
    {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView = p1
        convertView = LayoutInflater.from(context).inflate(R.layout.buttom_template, p2, false)
        name = convertView.findViewById(R.id.textView)
        name.text = arrayList[p0].name

        return convertView

    }
}