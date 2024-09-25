package com.example.b2b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class BuyerMyOrdersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buyer_active_my_orders, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.buyer_my_orders)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        super.onViewCreated(view, savedInstanceState)

        val productAImageView: ImageView = view.findViewById(R.id.product_a)
        val productBImageView: ImageView = view.findViewById(R.id.product_b)
        val productCImageView: ImageView = view.findViewById(R.id.product_c)
        val productDImageView: ImageView = view.findViewById(R.id.product_d)
        val productEImageView: ImageView = view.findViewById(R.id.product_e)
        val productFImageView: ImageView = view.findViewById(R.id.product_f)


        // Load images using Glide
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/dbe5d9b3-a377-437f-92f2-b1a5bf484a88")
            .placeholder(R.drawable.placeholder)
            .into(productAImageView)

        // Load images using Glide
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/dbe5d9b3-a377-437f-92f2-b1a5bf484a88")
            .placeholder(R.drawable.placeholder)
            .into(productBImageView)

        // Load images using Glide
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/dbe5d9b3-a377-437f-92f2-b1a5bf484a88")
            .placeholder(R.drawable.placeholder)
            .into(productCImageView)

        // Load images using Glide
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/dbe5d9b3-a377-437f-92f2-b1a5bf484a88")
            .placeholder(R.drawable.placeholder)
            .into(productDImageView)

        // Load images using Glide
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/dbe5d9b3-a377-437f-92f2-b1a5bf484a88")
            .placeholder(R.drawable.placeholder)
            .into(productEImageView)

        // Load images using Glide
        Glide.with(this)
            .load("https://github.com/user-attachments/assets/dbe5d9b3-a377-437f-92f2-b1a5bf484a88")
            .placeholder(R.drawable.placeholder)
            .into(productFImageView)
        return view
    }
}
