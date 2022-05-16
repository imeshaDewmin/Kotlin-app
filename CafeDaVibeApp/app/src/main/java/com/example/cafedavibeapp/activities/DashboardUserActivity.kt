package com.example.cafedavibeapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cafedavibeapp.databinding.ActivityDashboardUserBinding
import com.google.firebase.auth.FirebaseAuth

class DashboardUserActivity : AppCompatActivity() {

    //view binding
    private lateinit var binding: ActivityDashboardUserBinding

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click, logout
        binding.logoutBtn.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent( this, MainActivity::class.java))
            finish()
        }
        //handle click, open profile
        binding.profileBtn.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
        }
        //handle click, open profile
        binding.profileBtn.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
        }

    }
//this activity can be opened with or without login, so hide logout and profile button when user not logged in
    private fun checkUser() {
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null){
            //not logged in, user can saty in user dashboard without login too
            binding.subTitleTv.text = "Not Logged In"

            //hide profile, logout
            binding.profileBtn.visibility = View.GONE
            binding.logoutBtn.visibility = View.GONE
        }


        else{
            //logged in get and show user info
            val email = firebaseUser.email
            //set to textview of toolbar
            binding.subTitleTv.text = email

            //show profile, logout
            binding.profileBtn.visibility = View.VISIBLE
            binding.logoutBtn.visibility = View.VISIBLE


        }
    }
}