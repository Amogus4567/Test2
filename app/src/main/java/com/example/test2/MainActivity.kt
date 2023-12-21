package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton:Button = findViewById(R.id.button2)

        val robotsNum:Int = (2..12).random()

        rollButton.setOnClickListener(){
            val dice = Dice(6)
            val diceImage:ImageView = findViewById(R.id.imageView)
            val diceImage2:ImageView = findViewById(R.id.imageView2)
            val sumDice:TextView = findViewById(R.id.textView2)
            val youWin:TextView = findViewById(R.id.textView4)




            val diceSum = dice.diceRoll()
            val drawableResourse = when (diceSum){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            diceImage.setImageResource(drawableResourse)

            val diceSum2 = dice.diceRoll()
            val drawableResourse2 = when (diceSum2){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            diceImage2.setImageResource(drawableResourse2)
            val sumDiceIsReal = diceSum + diceSum2
            sumDice.text = sumDiceIsReal.toString()


            if (sumDiceIsReal < robotsNum) {youWin.text = "You Win!"}
            else {youWin.text = "You Lox!"}

        }
    }
}

class Dice (val numSides:Int) {
    fun diceRoll():Int {
        return (1..numSides).random()
    }
}



/*val toastRollMessage = Toast.makeText(this, "777", Toast.LENGTH_SHORT)
            toastRollMessage.show()

            result.text = dice.diceRoll().toString()
             */