package com.example.b2b

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class log_in : AppCompatActivity() {

    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText
    lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        // Find the views
        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_button)

        // Set the onClickListener for the login button
        loginBtn.setOnClickListener {
            // Capture the entered username and password
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            // Log the credentials (for testing purposes)
            Log.i("Login Info", "Username: $username, Password: $password")

            // Navigate to the sign_in activity
            val intent = Intent(this@log_in, SignIn::class.java)
            startActivity(intent)
        }
    }
}
