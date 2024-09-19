package com.example.b2b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class BuyerHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_buyer_home)
    }
}

class BuyerHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buyer_home, container, false)

        // Adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.buyer_home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up image slider
        val imageSlider = view.findViewById<ImageSlider>(R.id.featuredslider)
        val slideModels = mutableListOf<SlideModel>()
        slideModels.add(SlideModel(R.drawable.backup, ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://cdn.britannica.com/39/187439-050-35BA4DCA/Broccoli-florets.jpg", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://www.acs.edu.au/database/images/course_2892908.jpg", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://extension.unh.edu/sites/default/files/styles/landscape_480x192/public/media/2021-02/fruit-and-vegetable-crops_0.jpg?h=7961609c&itok=zeTgG2RK", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://post.healthline.com/wp-content/uploads/2020/03/romaine-lettuce-1296x728-body.jpg", ScaleTypes.CENTER_CROP))
        imageSlider.setImageList(slideModels)

        return view
    }
}