package com.nikolaykul.android.mvp.comparison.domain.main

/**
 * Created by nikolay
 */

data class Credentials(private val username: String, private val password: String) {
    fun isValid() = username.isNotEmpty() && password.isNotEmpty()
}