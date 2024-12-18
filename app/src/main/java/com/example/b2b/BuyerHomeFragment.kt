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
import android.widget.ImageView
import com.bumptech.glide.Glide

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

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.buyer_home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        super.onViewCreated(view, savedInstanceState)

//For Categories Filter
        val categoryAImageView: ImageView = view.findViewById(R.id.categoryAImageView)
        val categoryBImageView: ImageView = view.findViewById(R.id.categoryBImageView)
        val categoryCImageView: ImageView = view.findViewById(R.id.categoryCImageView)
        val categoryDImageView: ImageView = view.findViewById(R.id.categoryDImageView)
        val categoryEImageView: ImageView = view.findViewById(R.id.categoryEImageView)

        // Load images using Glide
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/f7809086-1fe5-4f0e-8b7a-915dd7ac8db2")
            .placeholder(R.drawable.placeholder)
            .into(categoryAImageView)

        Glide.with(this)
            .load("https://github.com/user-attachments/assets/e87709c8-89f0-4b45-81c6-9d6328926d5b")
            .placeholder(R.drawable.placeholder)
            .into(categoryBImageView)

        Glide.with(this)
            .load("https://github.com/user-attachments/assets/0988ac24-a852-4711-b32e-e371e762a480")
            .placeholder(R.drawable.placeholder)
            .into(categoryCImageView)

        Glide.with(this)
            .load("https://github.com/user-attachments/assets/b5e13192-3cda-4274-8181-424e1679c5cf")
            .placeholder(R.drawable.placeholder)
            .into(categoryDImageView)

        Glide.with(this)
            .load("https://github.com/user-attachments/assets/ae329bb0-83a7-4013-a952-7817346e4b81")
            .placeholder(R.drawable.placeholder)
            .into(categoryEImageView)


    // Set up image slider
        val imageSlider = view.findViewById<ImageSlider>(R.id.featuredslider)
        val slideModels = mutableListOf<SlideModel>()
        slideModels.add(SlideModel(R.drawable.backup, ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://cdn.britannica.com/39/187439-050-35BA4DCA/Broccoli-florets.jpg", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://www.acs.edu.au/database/images/course_2892908.jpg", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://extension.unh.edu/sites/default/files/styles/landscape_480x192/public/media/2021-02/fruit-and-vegetable-crops_0.jpg?h=7961609c&itok=zeTgG2RK", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://post.healthline.com/wp-content/uploads/2020/03/romaine-lettuce-1296x728-body.jpg", ScaleTypes.CENTER_CROP))
        imageSlider.setImageList(slideModels)

//For Product Content
        val featuredProduct1: ImageView = view.findViewById(R.id.featured_product1)
        val featuredProduct2: ImageView = view.findViewById(R.id.featured_product2)
        val featuredProduct3: ImageView = view.findViewById(R.id.featured_product3)
        val featuredProduct4: ImageView = view.findViewById(R.id.featured_product4)

        Glide.with(this)
            .load("https://github.com/user-attachments/assets/e8157211-7d55-4fbb-af45-10b48cda8b10")
            .placeholder(R.drawable.placeholder)
            .into(featuredProduct1)

        Glide.with(this)
            .load("https://github.com/user-attachments/assets/488835df-bf2b-4f3b-9758-2ad2fc2cb13d")
            .placeholder(R.drawable.placeholder)
            .into(featuredProduct2)

        Glide.with(this)
            .load("https://github.com/user-attachments/assets/a7ca1abe-9adc-4417-b03f-a22bda457c3b")
            .placeholder(R.drawable.placeholder)
            .into(featuredProduct3)

        Glide.with(this)
            .load(" https://github.com/user-attachments/assets/a2ac0319-faab-426a-bb35-477d719ec6c1")
            .placeholder(R.drawable.placeholder)
            .into(featuredProduct4)

        return view
    }
}