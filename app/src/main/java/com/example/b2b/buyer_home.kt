package com.example.b2b

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class BuyerHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // current layout
        setContentView(R.layout.activity_buyer_home)

        // Adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buyer_home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up image slider
        val imageSlider = findViewById<ImageSlider>(R.id.featuredslider)
        val slideModels = mutableListOf<SlideModel>()
        slideModels.add(SlideModel(R.drawable.backup, ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://cdn.britannica.com/39/187439-050-35BA4DCA/Broccoli-florets.jpg", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://www.acs.edu.au/database/images/course_2892908.jpg", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://extension.unh.edu/sites/default/files/styles/landscape_480x192/public/media/2021-02/fruit-and-vegetable-crops_0.jpg?h=7961609c&itok=zeTgG2RK", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://post.healthline.com/wp-content/uploads/2020/03/romaine-lettuce-1296x728-body.jpg", ScaleTypes.CENTER_CROP))
        imageSlider.setImageList(slideModels)

        // Bottom Navigation View
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set the active menu item for this activity
        bottomNavigationView.selectedItemId = R.id.home

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Active page
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
