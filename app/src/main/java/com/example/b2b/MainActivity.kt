package com.example.b2b

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


// Iterate through the BottomNavigationView items
        for (i in 0 until bottomNavigationView.childCount) {
            val itemView = bottomNavigationView.getChildAt(i)

            // Adjust the width of each item programmatically
            val params = itemView.layoutParams as ViewGroup.LayoutParams
            params.width = 500 // Set the desired width in pixels or convert dp to px
            itemView.layoutParams = params
        }


        if (savedInstanceState == null) {
            val userType = intent.getStringExtra("USER_TYPE")
            if (userType.isNullOrEmpty()) {
                // If USER_TYPE is null or empty, navigate to the LogIn page
                startActivity(Intent(this, LogIn::class.java))
                finish()
            } else {
                val initialFragment = when (userType) {
                    "buyer" -> BuyerHomeFragment()
                    "farmer" -> FarmerHomeFragment()
                    else -> BuyerHomeFragment() // Default fragment
                }
                loadFragment(initialFragment)
            }
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    loadFragment(BuyerHomeFragment())
                    true
                }
                R.id.my_orders -> {
                    loadFragment(BuyerMyOrdersFragment())
                    true
                }
                R.id.profile -> {
                    // loadFragment(BuyerProfileFragment())
                    true
                }
                R.id.chat -> {
                    // loadFragment(BuyerChatFragment())
                    true
                }
                R.id.cart -> {
                    // loadFragment(BuyerCartFragment())
                    true
                }
                else -> false
            }
        }
    }

    // Method to load fragments into the container
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}
