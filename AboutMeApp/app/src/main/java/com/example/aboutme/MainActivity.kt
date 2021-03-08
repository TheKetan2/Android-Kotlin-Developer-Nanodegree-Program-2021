package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.button)
        button.setOnClickListener {
            addNickName(it)
        }

    }
    private fun addNickName(view: View){
        val editText:EditText = findViewById<EditText>(R.id.edit_nickname)
        val nicknameTV:TextView = findViewById(R.id.nick_name_text)
        nicknameTV.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTV.visibility = View.VISIBLE

        // following two lines are used to hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}