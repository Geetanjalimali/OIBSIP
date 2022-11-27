package com.example.unitconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var backPressedTime = 0L
    override fun onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
        }
        else
        {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
        }
        backPressedTime=System.currentTimeMillis()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val heading=findViewById(R.id.unitconverter) as TextView
        val value=findViewById(R.id.Value) as EditText
        val ans=findViewById(R.id.ans) as TextView
        val cm=findViewById(R.id.cm) as Button
        val m=findViewById(R.id.meter) as Button
        val kg=findViewById(R.id.kg) as Button
        val gm=findViewById(R.id.gram) as Button


        cm.setOnClickListener {
            ans.text=(value.text.toString().toInt()*100).toString()
        }
        m.setOnClickListener {
            ans.text=(value.text.toString().toFloat()/100).toString()
        }
        kg.setOnClickListener {
            ans.text=(value.text.toString().toFloat()/1000).toString()
        }
        gm.setOnClickListener {
            ans.text=(value.text.toString().toInt()*1000).toString()
        }
    }
}
