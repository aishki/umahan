package com.example.b2b

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import java.util.Date
import java.text.SimpleDateFormat
import java.util.Locale

class BuyerMyOrdersFragment : Fragment() {

        //    FOR ORDERS
        private lateinit var ordersLayout: LinearLayout
        private lateinit var activeOrderTab: View
        private lateinit var completedOrderTab: View
        private lateinit var cancelledOrderTab: View

    private fun initViews(view: View) {
        ordersLayout = view.findViewById(R.id.ordersLayout)
        activeOrderTab = view.findViewById(R.id.radio_button1)
        completedOrderTab = view.findViewById(R.id.radio_button2)
        cancelledOrderTab = view.findViewById(R.id.radio_button3)

        // set a click listener to switch between different order statuses
        activeOrderTab.setOnClickListener { setOrderStatus("Active") }
        completedOrderTab.setOnClickListener { setOrderStatus("Inactive") }
        cancelledOrderTab.setOnClickListener { setOrderStatus("Completed") }
    }


    // Orders Model Class
        data class Orders(
            val name: String,
            val farmerName: String,
            val price: Int,
            val quantity: Int,
            val totalAmount: Int,
            val dateOrdered: Date,
            val dateDelivered: Date?,
            val status: String,
            val modeOfPayment: String,
            val image: String
        )

        private val activeOrders = listOf(
            Orders(
                name = "Mangoes",
                farmerName = "Farmer Juan",
                price = 90,
                quantity = 10,
                totalAmount = 900,
                dateOrdered = Date(2024, 9, 10),
                dateDelivered = null,  // Not delivered yet
                status = "Active",
                modeOfPayment = "Online Banking",
                image = "https://github.com/user-attachments/assets/b21356f6-f648-427b-af6d-a6fade68f892"
            ),
            Orders(
                name = "Bananas (Lakatan, Saba)",
                farmerName = "Farmer Pedro",
                price = 50,
                quantity = 20,
                totalAmount = 1000,
                dateOrdered = Date(2024, 9, 12),
                dateDelivered = null,
                status = "Active",
                modeOfPayment = "Cash",  // Cash
                image = "https://github.com/user-attachments/assets/e8157211-7d55-4fbb-af45-10b48cda8b10"
            ),
            Orders(
                name = "Pineapples",
                farmerName = "Farmer Luis",
                price = 40,
                quantity = 15,
                totalAmount = 600,
                dateOrdered = Date(2024, 9, 14),
                dateDelivered = null,
                status = "Active",
                modeOfPayment = "Cash on Delivery",
                image = "https://github.com/user-attachments/assets/488835df-bf2b-4f3b-9758-2ad2fc2cb13d"
            )
        )

        private val inactiveOrders = listOf(
            Orders(
                name = "Watermelons",
                farmerName = "Farmer Jose",
                price = 60,
                quantity = 8,
                totalAmount = 480,
                dateOrdered = Date(2024, 8, 25),
                dateDelivered = null,
                status = "Cancelled",
                modeOfPayment = "Online Payment",
                image = "https://github.com/user-attachments/assets/1f3e0db1-bb6c-4f47-94cb-54f44b89a3d5"
            ),
            Orders(
                name = "Limes",
                farmerName = "Farmer Maria",
                price = 20,
                quantity = 30,
                totalAmount = 600,
                dateOrdered = Date(2024, 8, 30),
                dateDelivered = null,
                status = "On Hold",
                modeOfPayment = "Cash",  // Cash
                image = "https://github.com/user-attachments/assets/c7eb7e85-7af0-4b1c-9c48-18e69f7b9b3e"
            )
        )

        private val completedOrders = listOf(
            Orders(
                name = "Papayas",
                farmerName = "Farmer Mateo",
                price = 30,
                quantity = 25,
                totalAmount = 750,
                dateOrdered = Date(2024, 8, 20),
                dateDelivered = Date(2024, 8, 22),
                status = "Completed",
                modeOfPayment = "Cash",  // Cash
                image = "https://github.com/user-attachments/assets/37a8fddf-50f7-4a89-a45d-4139f5cc6cee"
            ),
            Orders(
                name = "Guyabano (Soursop)",
                farmerName = "Farmer Sofia",
                price = 110,
                quantity = 5,
                totalAmount = 550,
                dateOrdered = Date(2024, 9, 5),
                dateDelivered = Date(2024, 9, 7),
                status = "Completed",
                modeOfPayment = "Cash on Delivery",  // COD
                image = "https://github.com/user-attachments/assets/7e921f6a-f3e1-4bf4-94c9-5f47447a8f39"
            ),
            Orders(
                name = "Rambutan",
                farmerName = "Farmer Emilio",
                price = 90,
                quantity = 12,
                totalAmount = 1080,
                dateOrdered = Date(2024, 9, 3),
                dateDelivered = Date(2024, 9, 6),
                status = "Completed",
                modeOfPayment = "Online Banking",  // Online payment
                image = "https://github.com/user-attachments/assets/a7ca1abe-9adc-4417-b03f-a22bda457c3b"
            )
        )

//ADD and UPDATE ORDERS
        private fun updateOrders(status: String) {
            ordersLayout.removeAllViews()

            when (status) {
                "Active" -> addOrders(activeOrders)
                "Inactive" -> addOrders(inactiveOrders)
                "Completed" -> addOrders(completedOrders)
            }
        }

        private fun addOrders(orders: List<Orders>) {
        ordersLayout.removeAllViews() // Clear any existing views

        for (order in orders) {
            val orderView = LayoutInflater.from(context).inflate(R.layout.order_item_layout, null)

            val orderName: TextView = orderView.findViewById(R.id.order_name)
            val orderFarmerName: TextView = orderView.findViewById(R.id.order_farmer_name)
            val orderTotal: TextView = orderView.findViewById(R.id.order_total)
            val orderImage: ImageView = orderView.findViewById(R.id.order_image)
            val dateDelivered: TextView = orderView.findViewById(R.id.order_delivered)
            val dateOrdered: TextView = orderView.findViewById(R.id.order_date)
            val orderQuantity: TextView = orderView.findViewById(R.id.order_quantity)
            val modeOfPayment: TextView = orderView.findViewById(R.id.order_mode_of_payment)
            val status: TextView = orderView.findViewById(R.id.order_status)

            // Date formatter for "Month Day, Year" format
            val dateFormatter = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())

            // Set data
            orderName.text = order.name
            orderFarmerName.text = "By ${order.farmerName}"
            orderTotal.text = "₱${order.totalAmount} Per kg"
            dateDelivered.text = order.dateDelivered.toString()
            dateOrdered.text = order.dateOrdered.toString()
            orderQuantity.text = order.quantity.toString()
            modeOfPayment.text = order.modeOfPayment
            status.text = order.status

            // Format the dateOrdered and dateDelivered
            dateOrdered.text = dateFormatter.format(order.dateOrdered)
            dateDelivered.text = order.dateDelivered?.let { dateFormatter.format(it) } ?: "Not Delivered"

            // Load image using Glide
            Glide.with(this).load(order.image).into(orderImage)

            // Add view to layout
            ordersLayout.addView(orderView)
        }
    }


    private fun setOrderStatus(status: String) {
        // reset the background to ensure only one is active
        resetOrderBackgrounds()

        // Use ContextCompat to get the actual color value
        val darkGreen = ContextCompat.getColor(requireContext(), R.color.darkgreen)

        when (status) {
            "Active" -> activeOrderTab.setBackgroundColor(darkGreen)
            "Inactive" -> completedOrderTab.setBackgroundColor(darkGreen)
            "Completed" -> cancelledOrderTab.setBackgroundColor(darkGreen)
        }

        // Update orders based on status
        updateOrders(status)
    }

    private fun resetOrderBackgrounds() {
        // Reset the background resource of all tabs (or set to default background if needed)
        activeOrderTab.setBackgroundResource(0)
        completedOrderTab.setBackgroundResource(0)
        cancelledOrderTab.setBackgroundResource(0)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buyer_active_my_orders, container, false)

        // Initialize views and set order status
        initViews(view)
        setOrderStatus("Active") // default to "Active" orders on load

        return view

    }
}
