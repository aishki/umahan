package com.example.b2b

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SignIn : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val backButton: ImageView = findViewById(R.id.back_arrow)
        val signUpButton: Button = findViewById(R.id.sign_up_button)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val buyerOption: RadioButton = findViewById(R.id.buyerOption)
        val farmerOption: RadioButton = findViewById(R.id.farmerOption)

        // password input and eye icon
        val passwordInput: EditText = findViewById(R.id.password_input)
        val eyeIcon: ImageView = findViewById(R.id.eye_icon)

        // Back Button Listener
        backButton.setOnClickListener {
            // Navigate to the log-in activity
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }

        // Sign Up Button listener
        signUpButton.setOnClickListener {
            // Check active radio button
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

        // password visibility
        eyeIcon.setOnClickListener {
            if (isPasswordVisible) {
                // Hide password
                passwordInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                eyeIcon.setImageResource(R.drawable.ic_eye_closed) // closed eye icon
            } else {
                // Show password
                passwordInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                eyeIcon.setImageResource(R.drawable.ic_eye_open) // open eye icon
            }
            // Move cursor to the end of the text
            passwordInput.setSelection(passwordInput.text.length)
            isPasswordVisible = !isPasswordVisible //s visibility flag
        }
    }
}
