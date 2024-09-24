package com.example.b2b

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

class MainActivity : AppCompatActivity() {

    private lateinit var userType: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set the default selected item to "Home"
        bottomNavigationView.selectedItemId = R.id.home

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
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.profile -> {
                    loadFragment(getFragmentByType("profile"))
                    true
                }
                R.id.cart -> {
                    loadFragment(getFragmentByType("cart"))
                    true
                }
                R.id.home -> {
                    loadFragment(getFragmentByType("home"))
                    true
                }
                R.id.my_orders -> {
                    loadFragment(getFragmentByType("my_orders"))
                    true
                }
                R.id.chat -> {
                    loadFragment(getFragmentByType("chat"))
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

    // Method to get the correct fragment based on user type and the selected item
    private fun getFragmentByType(fragmentType: String): Fragment {
        return when (userType) {
            "buyer" -> when (fragmentType) {
//                "profile" -> BuyerProfileFragment()
//                "cart" -> BuyerCartFragment()
                "home" -> BuyerHomeFragment()
                "my_orders" -> BuyerMyOrdersFragment()
//                "chat" -> BuyerChatFragment()
                else -> BuyerHomeFragment()
            }
            "farmer" -> when (fragmentType) {
//                "profile" -> FarmerProfileFragment()
//                "cart" -> FarmerCartFragment()
                "home" -> FarmerHomeFragment()
//                "my_orders" -> FarmerMyOrdersFragment()
//                "chat" -> FarmerChatFragment()
                else -> FarmerHomeFragment()
            }
            else -> BuyerHomeFragment() // Default to buyer
        }
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

