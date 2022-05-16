package com.example.cafedavibeapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cafedavibeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //view binding
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //handle click. login
        binding.LoginBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))

        }
        //hand click, skip and continue to main screen
        binding.skipBtn.setOnClickListener {
            startActivity(Intent(this, DashboardUserActivity::class.java))
        }
    }
}