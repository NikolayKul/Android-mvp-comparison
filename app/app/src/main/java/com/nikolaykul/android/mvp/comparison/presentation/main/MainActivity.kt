package com.nikolaykul.android.mvp.comparison.presentation.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nikolaykul.android.mvp.comparison.R
import com.nikolaykul.android.mvp.comparison.di.ActivityComponent
import com.nikolaykul.android.mvp.comparison.presentation.base.BaseActivity
import com.nikolaykul.android.mvp.comparison.utils.ToastUtils
import com.nikolaykul.android.mvp.comparison.utils.hideKeyboard
import com.nikolaykul.android.mvp.comparison.utils.textString
import jp.wasabeef.blurry.Blurry
import javax.inject.Inject

/**
 * Created by nikolay
 */

class MainActivity : BaseActivity(), MainMvpView {

    // see this issue for the details: `https://github.com/Arello-Mobile/Moxy/issues/100`
    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    // You probably would use a `DataBinding` or a `ButterKnife` or `Kotlin Android Extensions` for that
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

    @ProvidePresenter
    fun createPresenter(): MainPresenter = presenter

    override fun injectSelf(component: ActivityComponent) {
        component.inject(this)
    }

    override fun showLoading() {
        hideKeyboard(this)
        applyBlur()
        vgLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        vgLoading.visibility = View.GONE
    }

    override fun showLoginSuccess() {
        ToastUtils.showSuccess(this, R.string.main_message_success, Toast.LENGTH_SHORT)
    }

    override fun showLoginError() {
        ToastUtils.showError(this, R.string.main_message_error, Toast.LENGTH_SHORT)
    }

    private fun applyBlur() {
        findViewById<ViewGroup>(R.id.root).apply {
            post {
                Blurry.with(context)
                        .sampling(2)
                        .capture(this)
                        .into(findViewById(R.id.ivLoadingBackground))
            }
        }
    }

    private fun initListeners() {
        btnLogin.setOnClickListener {
            presenter.login(etUsername.textString(), etPassword.textString())
        }
    }

    private fun initViews() {
        btnLogin = findViewById(R.id.btnLogin)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        vgLoading = findViewById(R.id.vgLoading)
    }

}