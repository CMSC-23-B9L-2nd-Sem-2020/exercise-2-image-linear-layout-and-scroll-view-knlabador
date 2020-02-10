/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates a text view with a random
 * value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {

    lateinit var avengerImage : ImageView
    lateinit var avengerText : TextView
    lateinit var mainDescText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        avengerImage = findViewById(R.id.avenger_image)
        avengerText = findViewById(R.id.bio_text)
        mainDescText = findViewById(R.id.textView)

        avengerText.setText(R.string.reset_desc)

        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { resetDice() }
    }

    /**
     * Click listener for the Roll button.
     */
    private fun rollDice() {
        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()
        val randomInt = (1..10).random()


        val drawableResource = when (randomInt) {
            1 -> R.drawable.antman
            2 -> R.drawable.blackwidow
            3 -> R.drawable.captainamerica
            4 -> R.drawable.captainmarvel
            5 -> R.drawable.hawkeye
            6 -> R.drawable.hulk
            7 -> R.drawable.ironman
            8 -> R.drawable.okoye
            9 -> R.drawable.thor
            else -> R.drawable.warmachine
        }

        val textDescription = when (randomInt) {
            1 -> R.string.antman
            2 -> R.string.blackwidow
            3 -> R.string.captainamerica
            4 -> R.string.captainmarvel
            5 -> R.string.hawkeye
            6 -> R.string.hulk
            7 -> R.string.ironman
            8 -> R.string.okoye
            9 -> R.string.thor
            else -> R.string.warmachine
        }

        avengerImage.setImageResource(drawableResource)
        avengerText.setText(textDescription)
        mainDescText.setText(R.string.start_desc)
    }

    private fun resetDice() {
        avengerImage.setImageResource(R.drawable.avengers)
        avengerText.setText(R.string.reset_desc)
        mainDescText.setText(R.string.main_desc)

    }
}

