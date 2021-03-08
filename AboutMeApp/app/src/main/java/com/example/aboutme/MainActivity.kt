package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil

import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var myName: MyName = MyName("Ketan Ramteke")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName;
        binding.button.setOnClickListener {
            addNickName(it)
        }

    }
    private fun addNickName(view: View){
        binding.apply {
//            nickNameText.text = editNickname.text
            myName?.nickname = editNickname.text.toString()
            invalidateAll()
            editNickname.visibility = View.GONE
            button.visibility = View.GONE
            nickNameText.visibility = View.VISIBLE
        }

        // following two lines are used to hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}