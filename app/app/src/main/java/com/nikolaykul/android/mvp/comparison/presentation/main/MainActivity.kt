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
import javax.inject.Inject

/**
 * Created by nikolay
 */

class MainActivity : BaseActivity<MainPresenter>(), MainMvpView {

    // Otherwise you should explicitly define `Presenter`'s getter
    // in `ApplicationComponent` or `ActivityComponent` (depending on its scope)
    // and call it in `createPresenter`
    @Inject lateinit var injectedPresenter: MainPresenter

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
        presenter.attachView(this)
    }

    override fun createPresenter(): MainPresenter = injectedPresenter

    override fun injectSelf(component: ActivityComponent) {
        component.inject(this)
    }

    override fun showCredentials(username: String, password: String) {
        val msg = "Username: $username, password: $password"
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        hideKeyboard(this)
        applyBlur()
        vgLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
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