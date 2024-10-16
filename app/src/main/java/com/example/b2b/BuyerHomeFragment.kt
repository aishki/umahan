package com.example.b2b

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import java.util.Date

class BuyerHomeFragment : Fragment() {

    private lateinit var categoryA: ImageView
    private lateinit var categoryB: ImageView
    private lateinit var categoryC: ImageView
    private lateinit var categoryD: ImageView
    private lateinit var categoryE: ImageView
    private lateinit var productsLayout: LinearLayout

    // Product Model Class
    data class Product(
        val name: String,
        val price: String,
        val image: String
    )

    // Product Lists by Category
    private val fruitProducts = listOf(
        Product("Mangoes", "₱90/kg", "https://github.com/user-attachments/assets/b21356f6-f648-427b-af6d-a6fade68f892"),
        Product("Bananas (Lakatan, Saba)", "₱50/kg", "https://github.com/user-attachments/assets/e8157211-7d55-4fbb-af45-10b48cda8b10"),
        Product("Pineapples", "₱40/kg", "https://github.com/user-attachments/assets/488835df-bf2b-4f3b-9758-2ad2fc2cb13d"),
        Product("Papayas", "₱30/kg", "https://github.com/user-attachments/assets/37a8fddf-50f7-4a89-a45d-4139f5cc6cee"),
        Product("Guyabano (Soursop)", "₱110/kg", "https://github.com/user-attachments/assets/7e921f6a-f3e1-4bf4-94c9-5f47447a8f39"),
        Product("Rambutan", "₱90/kg", "https://github.com/user-attachments/assets/a7ca1abe-9adc-4417-b03f-a22bda457c3b"),
        Product("Lanzones", "₱100/kg", "https://github.com/user-attachments/assets/73d8f9f6-d425-4031-97f8-c5b8bb7d523f"),
        Product("Coconuts", "₱30/kg", "https://github.com/user-attachments/assets/a2ac0319-faab-426a-bb35-477d719ec6c1")
    )

    private val vegetableProducts = listOf(
        Product("Eggplant (Talong)", "₱70/kg", "https://github.com/user-attachments/assets/684ae1f5-4b5a-4245-97ba-c330b82c75da"),
        Product("Carrots", "₱90/kg", "https://github.com/user-attachments/assets/dbe5d9b3-a377-437f-92f2-b1a5bf484a88"),
        Product("Red Onions", "₱150/kg", "https://github.com/user-attachments/assets/4fdd7b2b-4b17-4216-ae88-6e1ded13e932"),
        Product("Lettuce", "₱130/kg", "https://github.com/user-attachments/assets/be56d271-921c-41c9-8409-52dc331f09be"),
        Product("Tomatoes (Kamatis)", "₱60/kg", "https://github.com/user-attachments/assets/7f44fc58-4e92-4954-ba6a-f753e5687bbd"),
        Product("Peppers (Siling Labuyo)", "₱250/kg", "https://github.com/user-attachments/assets/126c9555-b664-4536-916b-b8d2b0144275"),
        Product("Kangkong", "₱25/bundle", "https://github.com/user-attachments/assets/8b2f2240-c229-4f3c-8c56-fb7930e3bcb0"),
        Product("Upo (Calabash)", "₱40/kg", "https://github.com/user-attachments/assets/c3e3744a-dacb-495d-9108-6b4b8e6e4e52"),
        Product("Ampalaya (Bitter Melon)", "₱90/kg", "https://github.com/user-attachments/assets/f942d6fe-451d-4ddf-b074-06d3e99c8266"),
        Product("String Beans (Sitaw)", "₱60/kg", "https://github.com/user-attachments/assets/af5ccb2b-077b-401e-acba-acaedb433f08"),
    )

    private val grainsBeansProducts = listOf(
        Product("Rice", "₱50/kg", "https://github.com/user-attachments/assets/8530d560-8709-45e1-92d5-a2638ff8497d"),
        Product("Sugarcane", "Sold by the ton", "https://github.com/user-attachments/assets/58fa3b53-b363-43fd-b1c5-62384594544b"),
        Product("Corn", "₱25/kg", "https://github.com/user-attachments/assets/3e6f0dec-f0ef-4dbe-9936-3cedad730b48"),
        Product("Peanuts", "₱120/kg", "https://github.com/user-attachments/assets/ed882d92-b7cd-4722-88a9-84d6a29c5ecb"),
        Product("Sweet Potatoes (Kamote)", "₱40/kg", "https://github.com/user-attachments/assets/e59a8b80-3f6c-4866-a8e5-28dc989dc57d"),
        Product("Cassava", "₱35/kg", "https://github.com/user-attachments/assets/a74ed175-1f45-4ec0-8eb1-a9806af52aff")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buyer_home, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.buyer_home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize
        categoryA = view.findViewById(R.id.categoryAImageView)
        categoryB = view.findViewById(R.id.categoryBImageView)
        categoryC = view.findViewById(R.id.categoryCImageView)
        categoryD = view.findViewById(R.id.categoryDImageView)
        categoryE = view.findViewById(R.id.categoryEImageView)
        productsLayout = view.findViewById(R.id.productsLayout)

        // category click listeners
        categoryA.setOnClickListener { setActiveCategory("A") }
        categoryB.setOnClickListener { setActiveCategory("B") }
        categoryC.setOnClickListener { setActiveCategory("C") }
        categoryD.setOnClickListener { setActiveCategory("D") }
        categoryE.setOnClickListener { setActiveCategory("E") }

        // Load images using Glide
        loadCategoryImages()

        // Set up image slider
        setupImageSlider(view)

        // Load featured product images
        loadFeaturedProducts(view)

        // Load featured product images
        loadRecommendedProducts(view)

        // Initialize with default category
//        setActiveCategory("A")

        return view
    }

    private fun loadCategoryImages() {
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/f7809086-1fe5-4f0e-8b7a-915dd7ac8db2")
            .into(categoryA)
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/e87709c8-89f0-4b45-81c6-9d6328926d5b")
            .into(categoryB)
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/0988ac24-a852-4711-b32e-e371e762a480")
            .into(categoryC)
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/b5e13192-3cda-4274-8181-424e1679c5cf")
            .into(categoryD)
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/ae329bb0-83a7-4013-a952-7817346e4b81")
            .into(categoryE)
    }

    private fun setupImageSlider(view: View) {
        // Set up image slider
        val imageSlider = view.findViewById<ImageSlider>(R.id.featuredslider)
        val slideModels = mutableListOf<SlideModel>()
        slideModels.add(SlideModel("https://cdn.britannica.com/39/187439-050-35BA4DCA/Broccoli-florets.jpg", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://www.acs.edu.au/database/images/course_2892908.jpg", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://extension.unh.edu/sites/default/files/styles/landscape_480x192/public/media/2021-02/fruit-and-vegetable-crops_0.jpg?h=7961609c&itok=zeTgG2RK", ScaleTypes.CENTER_CROP))
        slideModels.add(SlideModel("https://post.healthline.com/wp-content/uploads/2020/03/romaine-lettuce-1296x728-body.jpg", ScaleTypes.CENTER_CROP))
        imageSlider.setImageList(slideModels)
    }

    private fun loadFeaturedProducts(view: View) {
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
            .load("https://github.com/user-attachments/assets/a2ac0319-faab-426a-bb35-477d719ec6c1")
            .placeholder(R.drawable.placeholder)
            .into(featuredProduct4)
    }

    private fun loadRecommendedProducts(view: View) {
        val recoProduct1: ImageView = view.findViewById(R.id.reco_product1)
        val recoProduct2: ImageView = view.findViewById(R.id.reco_product2)
        val recoProduct3: ImageView = view.findViewById(R.id.reco_product3)
        val recoProduct4: ImageView = view.findViewById(R.id.reco_product4)

        Glide.with(this)
            .load("https://github.com/user-attachments/assets/e8157211-7d55-4fbb-af45-10b48cda8b10")
            .placeholder(R.drawable.placeholder)
            .into(recoProduct1)

        Glide.with(this)
            .load("https://github.com/user-attachments/assets/488835df-bf2b-4f3b-9758-2ad2fc2cb13d")
            .placeholder(R.drawable.placeholder)
            .into(recoProduct2)

        Glide.with(this)
            .load("https://github.com/user-attachments/assets/a7ca1abe-9adc-4417-b03f-a22bda457c3b")
            .placeholder(R.drawable.placeholder)
            .into(recoProduct3)

        Glide.with(this)
            .load("https://github.com/user-attachments/assets/a2ac0319-faab-426a-bb35-477d719ec6c1")
            .placeholder(R.drawable.placeholder)
            .into(recoProduct4)
    }

    private fun setActiveCategory(category: String) {
        resetCategoryBackgrounds()

        when (category) {
            "A" -> categoryA.setBackgroundResource(R.drawable.active_category)
            "B" -> categoryB.setBackgroundResource(R.drawable.active_category)
            "C" -> categoryC.setBackgroundResource(R.drawable.active_category)
            "D" -> categoryD.setBackgroundResource(R.drawable.active_category)
            "E" -> categoryE.setBackgroundResource(R.drawable.active_category)
        }

        // Update product layout
        updateProducts(category)
    }

    private fun resetCategoryBackgrounds() {
        // Keep default background unchanged
        categoryA.setBackgroundResource(0)
        categoryB.setBackgroundResource(0)
        categoryC.setBackgroundResource(0)
        categoryD.setBackgroundResource(0)
        categoryE.setBackgroundResource(0)
    }

    private fun updateProducts(category: String) {
        productsLayout.removeAllViews()
        when (category) {
            "A" -> addProducts(fruitProducts)
            "B" -> addProducts(vegetableProducts)
            "C" -> addProducts(grainsBeansProducts)
            "D" -> addProducts(fruitProducts) // TEMPORARY ONLY
            "E" -> addProducts(grainsBeansProducts) // TEMPORARY ONLY
        }
    }

    private fun addProducts(products: List<Product>) {
        productsLayout.removeAllViews()
        Log.d("ProductList", "Number of products: ${products.size}")

        var currentRowLayout: LinearLayout? = null

        // Iterate through the products and add them to the layout
        for ((index, product) in products.withIndex()) {
            // Create a new row every two products
            if (index % 2 == 0) {
                currentRowLayout = LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                }
                productsLayout.addView(currentRowLayout)
                Log.d("ProductList", "Created new row for index: $index")
            }

            // Inflate product item layout
            val productView = LayoutInflater.from(context).inflate(R.layout.product_item_layout, null)
            val productImage: ImageView = productView.findViewById(R.id.product_image)
            val productName: TextView = productView.findViewById(R.id.product_name)
            val productPrice: TextView = productView.findViewById(R.id.product_price)

            Glide.with(this)
                .load(product.image)
                .placeholder(R.drawable.placeholder)
                .into(productImage)

            //product name and price
            productName.text = product.name
            productPrice.text = product.price

            // parameters for product box with margins
            val params = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply {
                setMargins(15, 35, 15, 0) // (left, top, right, bottom)
            }

            productView.layoutParams = params

            // add product view to the current row layout
            currentRowLayout?.addView(productView)
            Log.d("ProductItem", "Added view for ${product.name} to row.")
        }

        // debug log daw mahibi nko
        Log.d("ProductList", "Total views added: ${productsLayout.childCount}")
        Log.d("ProductsLayout", "Height after adding products: ${productsLayout.height}")
    }
}
