package com.example.b2b

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LogIn : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        // declare and initialize
        val emailInput: EditText = findViewById(R.id.username_input)
        val passwordInput: EditText = findViewById(R.id.password_input)
        val loginBtn: Button = findViewById(R.id.login_button)
        val signUpText: TextView = findViewById(R.id.signup_text)

        // Set the onClickListener for the login button
        loginBtn.setOnClickListener {
            // Capture the entered username and password
            val username = emailInput.text.toString()
            val password = passwordInput.text.toString()

            // Log the credentials (for testing purposes)
            Log.i("Login Info", "Username: $username, Password: $password")

            // Navigate to the sign_in activity
            val intent = Intent(this@LogIn, SignIn::class.java)
            startActivity(intent)
        }

        // Set up clickable span for "Sign Up"
        val spannableString = SpannableString(signUpText.text)
        val signUpClickable = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Navigate to the sign-in activity
                val intent = Intent(this@LogIn, SignIn::class.java)
                startActivity(intent)
            }
        }

        // start and end of "Sign Up"
        val signUpTextStart = spannableString.indexOf("Sign Up")
        val signUpTextEnd = signUpTextStart + "Sign Up".length

        // clickable span for "Sign Up"
        spannableString.setSpan(signUpClickable, signUpTextStart, signUpTextEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        // color for "Sign Up" text
        val signUpColorSpan = ForegroundColorSpan(Color.parseColor("#E95322"))
        spannableString.setSpan(signUpColorSpan, signUpTextStart, signUpTextEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Set the spannable string to the TextView
        signUpText.text = spannableString
        signUpText.movementMethod = android.text.method.LinkMovementMethod.getInstance()
    }
}
