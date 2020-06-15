package com.convert.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.math.*
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val e: EditText = findViewById(R.id.e)
        val s1: Spinner = findViewById(R.id.s1)
        val s2: Spinner = findViewById(R.id.s2)
        val b: Button = findViewById(R.id.but)
        val r: TextView = findViewById(R.id.res)

        val clist1 = arrayOf("USD", "RUB")
        val aa1 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, clist1)

        s1.adapter = aa1

        val clist2 = arrayOf("RUB", "USD")
        val aa2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, clist2)

        s2.adapter = aa2

        b.setOnClickListener {
            val a: Double = e.text.toString().toDouble()
            val c1: String = s1.selectedItem.toString()
            val c2: String = s2.selectedItem.toString()

            if (a < 0.0) {
                r.text = "Error"
            }

            else if ((c1 == "USD" && c2 == "USD") || (c1 == "RUB" && c2 == "RUB")) {
                r.text = a.toString()
            }

            else if (c1 == "USD" && c2 == "RUB") {
                val a1: Double = a*74
                r.text = a1.toString()
            }

            else {
                val a2: Double = a/74
                r.text = a2.toString()
            }


        }
    }
}