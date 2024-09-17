package com.example.b2b

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class SignIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signUpButton: Button = findViewById(R.id.sign_up_button)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val buyerOption: RadioButton = findViewById(R.id.buyerOption)
        val farmerOption: RadioButton = findViewById(R.id.farmerOption)

        // Sign Up Button listener
        signUpButton.setOnClickListener {
            // Check which radio button is selected
            val selectedId = radioGroup.checkedRadioButtonId

            if (selectedId == buyerOption.id) {
                // Start Buyer Home Activity
                val intent = Intent(this, BuyerHome::class.java)
                startActivity(intent)
            } else if (selectedId == farmerOption.id) {
                // Start Farmer Home Activity
                val intent = Intent(this, FarmerHome::class.java)
                startActivity(intent)
            }
        }
    }
}
