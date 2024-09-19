package com.example.b2b

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class BuyerMyOrders : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // current layout
        setContentView(R.layout.activity_buyer_my_orders)

        // Adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buyer_my_orders)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Bottom Navigation View
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set active menu item for activity
        bottomNavigationView.selectedItemId = R.id.my_orders

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val intent = Intent(this, BuyerHome::class.java)
                    startActivity(intent)
                    true
                }
                R.id.profile -> {
                    // Navigate to the profile activity
                    // val intent = Intent(this, BuyerProfile::class.java)
                    // startActivity(intent)
                    true
                }
                R.id.my_orders -> {
                    // Active page
                    val intent = Intent(this, BuyerMyOrders::class.java)
                    startActivity(intent)
                    true
                }
                R.id.chat -> {
                    // Navigate to the chat activity
                    // val intent = Intent(this, BuyerChat::class.java)
                    // startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
