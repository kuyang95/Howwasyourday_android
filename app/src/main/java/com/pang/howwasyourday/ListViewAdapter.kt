package com.pang.howwasyourday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.pang.howwasyourday.databinding.ListBorderBinding

// 리스트뷰에 달아줄 아답터 클래스
class BorderListViewAdapter (private val items : MutableList<BorderListViewItem>): BaseAdapter() {
        override fun getCount(): Int = items.size

        override fun getItem(p0: Int): BorderListViewItem = items[p0]

        override fun getItemId(p0: Int): Long = p0.toLong()

        override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
            var convertView = view
            if(convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.list_border, parent,false)

            val item: BorderListViewItem = items[position]

            val day = convertView!!.findViewById<TextView>(R.id.tv_day)
            val dotw = convertView.findViewById<TextView>(R.id.tv_dotw)
            val listview = convertView.findViewById<ListView>(android.R.id.list)

            //ContextCompat.getDrawable(listview.context, R.drawable.mouse_large)!!,
            val objectItems = mutableListOf<ObjectListViewItem>()
            objectItems.add(ObjectListViewItem( "오늘 어떄?", "좋아"))
            objectItems.add(ObjectListViewItem("별점을 준다면?", "3개"))
            val objectAdapter = ObjectListViewAdapter(objectItems)

            day.text = item.day.split(" ")[0]
            dotw.text = item.day.split(" ")[1]
            listview.adapter = objectAdapter






            return convertView
        }
    }

class ObjectListViewAdapter (private val items :  MutableList<ObjectListViewItem>) : BaseAdapter() {
    override fun getCount(): Int = items.size

    override fun getItem(p0: Int): ObjectListViewItem = items[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val convertView = view
        if(convertView == null) LayoutInflater.from(parent?.context).inflate(R.layout.list_object, parent, false)

        val item : ObjectListViewItem = items[position]

        //val image = convertView!!.findViewById<ImageView>(R.id.iv1)
        val title = convertView!!.findViewById<TextView>(R.id.tv_question)
        val answer = convertView.findViewById<TextView>(R.id.tv_answer)

        //image.setImageDrawable(item.image)
        title.text = item.title
        answer.text = item.answer

        return convertView
    }
}
