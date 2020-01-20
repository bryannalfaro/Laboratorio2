package com.example.laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnLongClickListener {


    private var counter=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1:Button=findViewById(R.id.button1)
        val button2:Button=findViewById(R.id.button2)
        val counterText:TextView=findViewById(R.id.counter)
        val imageCongrats:ImageView=findViewById(R.id.congrats)

        button1.setOnClickListener {
            incrementCounter()
            counterText.text = counter.toString()
        }

        button1.setOnLongClickListener(this)

        button2.setOnClickListener {
            resetCounter()
            counterText.text = counter.toString()
        }

    }
    override fun onLongClick(v: View?): Boolean {
        message()
        return false
    }

    fun incrementCounter(){
        if(counter<=20){
            counter++
        }else{
            resetCounter()
        }

    }

    fun resetCounter(){
        counter=0
    }

    fun message(){

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
