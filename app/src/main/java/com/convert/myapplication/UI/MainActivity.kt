package com.convert.myapplication.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.convert.myapplication.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val e: EditText = findViewById(R.id.e)
        val s1: Spinner = findViewById(R.id.s1)
        val s2: Spinner = findViewById(R.id.s2)
        val b: Button = findViewById(R.id.but)
        val r: TextView = findViewById(R.id.res)

        val list1 = arrayOf("USD", "RUB", "EUR", "GBP")
        val aa1 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list1)

        s1.adapter = aa1

        val list2 = arrayOf("RUB", "USD", "EUR", "GBP")
        val aa2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list2)

        s2.adapter = aa2

        b.setOnClickListener {
            val a: Double = e.text.toString().toDouble()
            val c1: String = s1.selectedItem.toString()
            val c2: String = s2.selectedItem.toString()

            if (a < 0.0) {
                r.text = "Error"
            }

            else if ((c1 == "USD" && c2 == "USD") || (c1 == "RUB" && c2 == "RUB") || (c1 == "EUR" && c2 == "EUR") || (c1 == "GBP" && c2 == "GBP")) {
                r.text = a.toString()
            }

            // USD
            else if (c1 == "USD" && c2 == "RUB") {
                val a1: Double = a*70.13
                r.text = a1.toString()
            }

            else if (c1 == "USD" && c2 == "EUR") {
                val a1: Double = a/1.13
                r.text = a1.toString()
            }

            else if (c1 == "USD" && c2 == "GBP"){
                val a1: Double = a/1.26
                r.text = a1.toString()
            }

            // RUB

            else if (c1 == "RUB" && c2 == "USD") {
                val a1: Double = a/70.13
                r.text = a1.toString()
            }

            else if (c1 == "RUB" && c2 == "EUR") {
                val a1: Double = a/78.94
                r.text = a1.toString()
            }

            else if (c1 == "RUB" && c2 == "GBP"){
                val a1: Double = a/87.7
                r.text = a1.toString()
            }

            // EUR

            else if (c1 == "EUR" && c2 == "USD") {
                val a1: Double = a*1.13
                r.text = a1.toString()
            }

            else if (c1 == "EUR" && c2 == "RUB"){
                val a1: Double = a*78.94
                r.text = a1.toString()
            }

            else if (c1 == "EUR" && c2 == "GBP"){
                val a1: Double = a/1.11
                r.text = a1.toString()
            }

            // GBP

            else if (c1 == "GBP" && c2 == "EUR"){
                val a1: Double = a*1.11
                r.text = a1.toString()
            }

            else if (c1 == "GBP" && c2 == "USD"){
                val a1: Double = a*1.26
                        r.text = a1.toString()
            }

            else {
                val a1: Double = a*87.7
                r.text = a1.toString()
            }
        }
    }
}