package com.pang.howwasyourday

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.pang.howwasyourday.databinding.ActivityMainBinding
import com.pang.howwasyourday.databinding.ListBorderBinding


class MainActivity : AppCompatActivity() {

    private lateinit var borderBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) 뷰 바인딩으로 뷰 생성할거라 여기서 안씀

        // 상태바 색상 투명으로 만듬
        window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.TRANSPARENT

        // 액션바 숨김
        supportActionBar?.hide()

        // 뷰를 생성하고 xml 의 뷰를 id로 가져오기 위해 binding 사용

        borderBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = borderBinding.root
        setContentView(view)

        // 수정이 가능한 리스트
        val borderItems = mutableListOf<BorderListViewItem>()


        //
        borderItems.add(BorderListViewItem( "2일 SAT"))
        borderItems.add(BorderListViewItem("3일 SUN"))




        // 리스트뷰에 아답터 연결
        val borderAdapter = BorderListViewAdapter(borderItems)

        borderBinding.listView.adapter = borderAdapter



    }


}