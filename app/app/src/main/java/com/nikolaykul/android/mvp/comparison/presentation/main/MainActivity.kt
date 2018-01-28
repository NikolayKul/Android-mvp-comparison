package com.nikolaykul.android.mvp.comparison.presentation.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.nikolaykul.android.mvp.comparison.R
import com.nikolaykul.android.mvp.comparison.di.ActivityComponent
import com.nikolaykul.android.mvp.comparison.presentation.base.BaseActivity
import com.nikolaykul.android.mvp.comparison.utils.hideKeyboard
import com.nikolaykul.android.mvp.comparison.utils.textString
import jp.wasabeef.blurry.Blurry

/**
 * Created by nikolay
 */

private const val LOADING_MILLIS = 500L

class MainActivity : BaseActivity() {

    private lateinit var btnLogin: Button
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var vgLoading: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListeners()
    }

    override fun injectSelf(component: ActivityComponent) {
        component.inject(this)
    }

    private fun showCredentials() {
        val msg = "Username: ${etUsername.textString()}, password: ${etPassword.textString()}"
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun showLoading() {
        hideKeyboard(this)
        applyBlur()
        vgLoading.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        vgLoading.visibility = View.GONE
    }

    private fun applyBlur() {
        Blurry.with(this)
                .sampling(2)
                .capture(findViewById(R.id.root))
                .into(findViewById(R.id.ivLoadingBackground))
    }

    private fun initListeners() {
        btnLogin.setOnClickListener {
            showLoading()
            vgLoading.postDelayed({
                hideLoading()
                showCredentials()
            }, LOADING_MILLIS)
        }
    }

    // You probably would use a `DataBinding` or a `ButterKnife` or `Kotlin Android Extensions` for that
    private fun initViews() {
        btnLogin = findViewById(R.id.btnLogin)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        vgLoading = findViewById(R.id.vgLoading)
    }

}