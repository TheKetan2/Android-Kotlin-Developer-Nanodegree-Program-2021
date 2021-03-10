package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val boxone:TextView = findViewById(R.id.box_one)
//        val boxtwo:TextView = findViewById(R.id.box_two)
//        val boxthree:TextView = findViewById(R.id.box_three)
//        val boxfour:TextView = findViewById(R.id.box_four)
//        val boxfive:TextView = findViewById(R.id.box_five)
//        val btnRed: Button = findViewById(R.id.button_red)
//        val btnYellow: Button = findViewById(R.id.button_yellow)
//        val btnGreen: Button = findViewById(R.id.button_green)
//        val constraintLayout:ConstraintLayout = findViewById(R.id.constraintLayout)
        val clickableViews: List<View> = listOf(binding.boxOne, binding.boxTwo, binding.boxThree, binding.boxFour,
            binding.boxFive, binding.constraintLayout, binding.buttonRed, binding.buttonGreen, binding.buttonYellow)
        setListener(clickableViews)
    }

    private fun setListener(clickableViews: List<View>){
        for(item in clickableViews){
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View){
        when(view.id){
            R.id.box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three -> view.setBackgroundResource(android.R.color.holo_blue_light)
            R.id.box_four -> view.setBackgroundResource(android.R.color.holo_orange_dark)
            R.id.box_five -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.button_red -> binding.boxThree.setBackgroundColor(Color.RED)
            R.id.button_yellow -> binding.boxFour.setBackgroundColor(Color.YELLOW)
            R.id.button_green -> binding.boxFive.setBackgroundColor(Color.GREEN)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}