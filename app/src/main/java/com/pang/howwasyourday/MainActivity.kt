package com.pang.howwasyourday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.pang.howwasyourday.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val items = mutableListOf<ListViewItem>()

        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.mouse_large)!!, "2일 SAT", "오늘 하루 어땠어?", "그냥 그랬어"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.mouse_large)!!, "3일 SUN", "좋아따", "하이"))

        val adapter = ListViewAdapter(items)

        binding.listView.adapter = adapter


    }


}