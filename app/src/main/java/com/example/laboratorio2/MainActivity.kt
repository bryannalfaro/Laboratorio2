package com.example.laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

/**
 * @author Bryann Alfaro
 *@since January 24rd,2020
 *
 */
class MainActivity : AppCompatActivity(){


    private var counter=0
    lateinit var imageCongrats:ImageView

    /**
     * Function that creates the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1:Button=findViewById(R.id.button1)
        val button2:Button=findViewById(R.id.button2)
        val counterText:TextView=findViewById(R.id.counter)
        imageCongrats=findViewById(R.id.congrats)

        button1.setOnClickListener {
            incrementCounter()
            counterText.text = counter.toString()
        }

        button1.setOnLongClickListener {
            message()
            counter--
            true
        }

        button2.setOnClickListener {
            resetCounter()
            counterText.text = counter.toString()
        }
        counterText.text = counter.toString()

    }
    /**
     * Function to increment the counter
     */
    private fun incrementCounter(){
        if (counter==9){
            Toast.makeText(this,"Felicitaciones lograste tu primera meta",Toast.LENGTH_SHORT).show()
            imageCongrats.isVisible=true
            imageCongrats.setImageResource(R.drawable.felicitaciones)
            counter++
        }else if(counter<=18){
            counter++
            imageCongrats.isVisible=false
        }else if (counter==19){
            counter++
            Toast.makeText(this,"Felicitaciones",Toast.LENGTH_SHORT).show()
            imageCongrats.isVisible=true
            imageCongrats.setImageResource(R.drawable.indice)
        }else{

        }

    }

    /**
     * Function to reset the count and set the image invisible
     */
    private fun resetCounter(){
        counter=0
        imageCongrats.isVisible=false
    }

    /**
     * Function that sends the message in the Toast
     */
    private fun message(){

        //goals for win
        var goal1=10-counter
        var goal2=20-counter

        //evaluate the first goal and then put the second goal in the Toast message
        if(goal1>=0){
            Toast.makeText(this,"Te faltan $goal1 para tu primera meta",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Te faltan $goal2 para tu segunda meta",Toast.LENGTH_SHORT).show()
        }

    }
}
