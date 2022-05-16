package com.example.foodlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FoodlistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foodlist)

        val seeBtn1 : Button = findViewById(R.id.see1)

        seeBtn1.setOnClickListener {
            val intent= Intent(this,PizzalistActivity::class.java)
            startActivity(intent)
        }

        val seeBtn2 : Button = findViewById(R.id.see2)

        seeBtn2.setOnClickListener {
            val intent= Intent(this,BurgerlistActivity::class.java)
            startActivity(intent)
        }

        val seeBtn3 : Button = findViewById(R.id.see3)

        seeBtn3.setOnClickListener {
            val intent= Intent(this,ShorteatslistActivity::class.java)
            startActivity(intent)
        }

        val seeBtn4 : Button = findViewById(R.id.see4)

        seeBtn4.setOnClickListener {
            val intent= Intent(this,BeveragelistActivity::class.java)
            startActivity(intent)
        }

    }
}