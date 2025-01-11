package com.ss.diceroller

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random
class MainActivity : AppCompatActivity() {
    lateinit var discImage: ImageView
    private var mp: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button=findViewById(R.id.roll_button)
        mp = MediaPlayer.create(this, R.raw.roll)
        rollButton.setOnClickListener {

            try {
                // In a try block call rollDice() method to show the
                // dice roll animation. We'll define this method below.
                rollDice()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        discImage = findViewById(R.id.disc_image)
    }

    private fun rollDice() {

        val randNumber = Random().nextInt(6)+1
        val darwableResource = when(randNumber)
        {
           1 -> R.drawable.dice_1
           2 -> R.drawable.dice_2
           3 -> R.drawable.dice_3
           4 -> R.drawable.dice_4
           5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        mp?.start()
        discImage.setImageResource(darwableResource)
    }
}