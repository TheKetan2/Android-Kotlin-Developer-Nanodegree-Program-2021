package com.example.colormeapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_tv)
        val boxTwoText = findViewById<TextView>(R.id.box_two_tv)
        val boxThreeText = findViewById<TextView>(R.id.box_three_tv)
        val boxFourText = findViewById<TextView>(R.id.box_four_tv)
        val boxFiveText = findViewById<TextView>(R.id.box_five_tv)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableView: List<View> = listOf(
                boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, rootConstraintLayout
        )
        for (item in clickableView) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one_tv -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_tv -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_tv -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_tv -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_tv -> view.setBackgroundColor(Color.BLUE)
            else -> view.setBackgroundColor(Color.LTGRAY)

        }
    }
}