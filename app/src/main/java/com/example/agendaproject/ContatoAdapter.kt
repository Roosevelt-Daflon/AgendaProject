package com.example.agendaproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.AdapterView

class ContatoAdapter (private val context: Context, private val arrayList: java.util.ArrayList<Contato>) : BaseAdapter()
{
    private  lateinit var name : TextView

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView = p1
        convertView = LayoutInflater.from(context).inflate(R.layout.buttom_template, p2, false)
        name = convertView.findViewById(R.id.textView)
        name.text = arrayList[p0].nome

        return convertView
    }

}