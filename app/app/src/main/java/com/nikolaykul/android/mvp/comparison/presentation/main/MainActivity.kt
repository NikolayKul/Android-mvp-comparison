package com.nikolaykul.android.mvp.comparison.presentation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.nikolaykul.android.mvp.comparison.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListeners()
    }

    private fun initListeners() {
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            showCredentials(username, password)
        }
    }

    /**
     * You probably would use a `DataBinding` or a `ButterKnife` or `Kotlin Android Extensions` for that
     */
    private fun initViews() {
        btnLogin = findViewById(R.id.btnLogin)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
    }

    private fun showCredentials(username: String, password: String) {
        val msg = "Username: $username, password: $password"
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}