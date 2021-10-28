package com.pang.howwasyourday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.pang.howwasyourday.databinding.ActivityHelloQuistionBinding

class HelloQuistion : AppCompatActivity() {

    private lateinit var binding : ActivityHelloQuistionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_hello_quistion)

        // view Vinding 사용해서 view 접근
        binding = ActivityHelloQuistionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.et1.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                if(binding.et1.text.toString().equals("")){
                    binding.enterButton.visibility = View.INVISIBLE
                }
                else{
                    binding.enterButton.visibility = View.VISIBLE
                }


            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

        binding.enterButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


}