package com.pang.howwasyourday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapter (private val items : MutableList<ListViewItem>): BaseAdapter() {
        override fun getCount(): Int = items.size

        override fun getItem(p0: Int): ListViewItem = items[p0]

        override fun getItemId(p0: Int): Long = p0.toLong()

        override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
            var convertView = view
            if(convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent,false)


            val item: ListViewItem = items[position]

            val icon = convertView!!.findViewById<ImageView>(R.id.iv1)
            val day = convertView.findViewById<TextView>(R.id.tv_day)
            val dotw = convertView.findViewById<TextView>(R.id.tv_dotw)
            val title = convertView.findViewById<TextView>(R.id.tv_question)
            val answer = convertView.findViewById<TextView>(R.id.tv_answer)

            icon.setImageDrawable(item.image)
            day.text = item.day.split(" ")[0]
            dotw.text = item.day.split(" ")[1]
            title.text = item.title
            answer.text = item.answer


           return convertView
        }
    }
