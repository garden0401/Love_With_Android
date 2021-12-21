package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.dicegame.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        BtnDiceStartEvent()

    }

    private fun BtnDiceStartEvent() {
        val DiceImage1 = binding.ivDice1
        val DiceImage2 = binding.ivDice2

        binding.btnDiceStart.setOnClickListener {
            Toast.makeText(this, "주사위 GO!!", Toast.LENGTH_LONG).show()

            val number1 = Random.nextInt(1, 6)
            val number2 = Random.nextInt(1, 6)

            // 첫번째 주사위
            if (number1 == 1) {
                DiceImage1.setImageResource(R.drawable.dice_1)
            } else if (number1 == 2) {
                DiceImage1.setImageResource(R.drawable.dice_2)
            } else if (number1 == 3) {
                DiceImage1.setImageResource(R.drawable.dice_3)
            } else if (number1 == 4) {
                DiceImage1.setImageResource(R.drawable.dice_4)
            } else if (number1 == 5) {
                DiceImage1.setImageResource(R.drawable.dice_5)
            } else {
                DiceImage1.setImageResource(R.drawable.dice_6)
            }

            // 두번째 주사위
            if (number2 == 1) {
                DiceImage2.setImageResource(R.drawable.dice_1)
            } else if (number1 == 2) {
                DiceImage2.setImageResource(R.drawable.dice_2)
            } else if (number1 == 3) {
                DiceImage2.setImageResource(R.drawable.dice_3)
            } else if (number1 == 4) {
                DiceImage2.setImageResource(R.drawable.dice_4)
            } else if (number1 == 5) {
                DiceImage2.setImageResource(R.drawable.dice_5)
            } else {
                DiceImage2.setImageResource(R.drawable.dice_6)
            }


        }
    }


}
