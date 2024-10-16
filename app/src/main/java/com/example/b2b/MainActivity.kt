package com.example.b2b

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

class MainActivity : AppCompatActivity() {

    private lateinit var userType: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationBuyer = findViewById<BottomNavigationView>(R.id.bottom_navigation_buyer)
        val bottomNavigationFarmer = findViewById<BottomNavigationView>(R.id.bottom_navigation_farmer)

        // Set the default selected item to "Home"
        bottomNavigationBuyer.selectedItemId = R.id.home

        // Set the default selected item to "Home"
        bottomNavigationFarmer.selectedItemId = R.id.farmer_home

        // Get userType from intent
        userType = intent.getStringExtra("USER_TYPE").orEmpty()

        if (userType.isEmpty()) {
            // If USER_TYPE is null or empty, navigate to the LogIn page
            startActivity(Intent(this, LogIn::class.java))
            finish()
        } else {
            // Load the initial fragment based on the user type
            if (savedInstanceState == null) {
                loadInitialFragment(userType)
            }

            // Show the appropriate navigation view
            when (userType) {
                "buyer" -> {
                    bottomNavigationBuyer.visibility = View.VISIBLE
                    bottomNavigationFarmer.visibility = View.GONE
                }
                "farmer" -> {
                    bottomNavigationFarmer.visibility = View.VISIBLE
                    bottomNavigationBuyer.visibility = View.GONE
                }
                else -> {
                    // Default to buyer if user type is unknown
                    bottomNavigationBuyer.visibility = View.VISIBLE
                    bottomNavigationFarmer.visibility = View.GONE
                }
            }
        }

        // Set up the listeners for the navigation views
        bottomNavigationBuyer.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.profile -> {
//                    loadFragment(BuyerProfileFragment())
                    true
                }
                R.id.cart -> {
//                    loadFragment(BuyerCartFragment())
                    true
                }
                R.id.home -> {
                    loadFragment(BuyerHomeFragment())
                    true
                }
                R.id.my_orders -> {
                    loadFragment(BuyerMyOrdersFragment())
                    true
                }
                R.id.chat -> {
//                    loadFragment(BuyerChatFragment())
                    true
                }
                else -> false
            }
        }

        bottomNavigationFarmer.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mga_orders -> {
                    bottomNavigationFarmer.itemBackground = ContextCompat.getDrawable(this, R.drawable.nav_item_bg_farmer_orders_selector)
//                    loadFragment(FarmerMgaOrdersFragment())
                    true
                }
                R.id.akon_baligya -> {
                    bottomNavigationFarmer.itemBackground =  ContextCompat.getDrawable(this, R.drawable.nav_item_bg_farmer_akon_baligya_selector)
//                    loadFragment(FarmerAkonBaligyaFragment())

                    true
                }
                R.id.farmer_home -> {
                    bottomNavigationFarmer.itemBackground = ContextCompat.getDrawable(this, R.drawable.nav_item_background_selector)
                    loadFragment(FarmerHomeFragment())
                    true
                }
                R.id.farmer_profile -> {
                    bottomNavigationFarmer.itemBackground =  ContextCompat.getDrawable(this, R.drawable.nav_item_bg_farmer_profile_selector)
//                    loadFragment(FarmerProfileFragment())
                    true
                }
                R.id.chat -> {
                    bottomNavigationFarmer.itemBackground =  ContextCompat.getDrawable(this, R.drawable.nav_item_bg_farmer_chat_selector)
//                    loadFragment(FarmerChatsFragment())
                    true
                }
                else -> false
            }
        }
    }


    // Method to load the initial fragment based on user type
    private fun loadInitialFragment(userType: String) {
        val initialFragment = when (userType) {
            "buyer" -> BuyerHomeFragment()
            "farmer" -> FarmerHomeFragment()
            else -> BuyerHomeFragment() // Default to buyer
        }
        loadFragment(initialFragment)
    }

    // Method to load fragments into the container
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }


    private fun getClient(){
        val client = createSupabaseClient(
            supabaseUrl = "https://fnglhqwyctxtqmnftlre.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZuZ2xocXd5Y3R4dHFtbmZ0bHJlIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MjcxNjQ3MjUsImV4cCI6MjA0Mjc0MDcyNX0.WYqJ2EriP9m1a6oCOT8bMbpyZC64TU4Lr4akQmbLVbI",
        ) {
            install(Postgrest)
        }
    }
}


