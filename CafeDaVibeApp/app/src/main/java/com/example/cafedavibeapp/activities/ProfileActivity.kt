package com.example.cafedavibeapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.cafedavibeapp.R
import com.example.cafedavibeapp.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {

    //view binding
    private lateinit var binding : ActivityProfileBinding

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        loadUserInfo()

        //handle click, go back
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        //handle click, open edit profile
        binding.profileEditBtn.setOnClickListener {
            startActivity(Intent(this,ProfileEditActivity::class.java))
        }

    }

    private fun loadUserInfo() {
        //db reference to load user info
        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(firebaseAuth.uid!!)
            .addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    //get user info
                    val email = "${snapshot.child("email").value}"
                    val name = "${snapshot.child("name").value}"
                    val profileImage = "${snapshot.child("profileImage").value}"
                    val date = "${snapshot.child("timestamp").value}"
                    val uid = "${snapshot.child("uid").value}"
                    val address = "${snapshot.child("address").value}"
                    val phone = "${snapshot.child("phone").value}"


                    //convert timestamp to proper date format
                  // val formattedDate = MyApplication.formatTimesTamp(timestamp.toLong())


                    //set data
                    binding.nameTv.text = name
                    binding.emailTv.text = email
                    //binding.memberDateTv.text = formattedDate
                    binding.addressTv.text = address
                    binding.PhoneTv.text=phone

                     //set image
                    try {
                        Glide.with(this@ProfileActivity)
                            .load(profileImage)
                            .placeholder(R.drawable.ic_person_gray)
                            .into(binding.profileTv)
                    }
                    catch (e: Exception){

                    }


                }

                override fun onCancelled(error: DatabaseError) {

                }
            })



    }
}