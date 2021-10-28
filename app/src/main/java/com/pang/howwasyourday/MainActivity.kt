package com.pang.howwasyourday

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.pang.howwasyourday.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.TRANSPARENT

        supportActionBar?.hide()

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