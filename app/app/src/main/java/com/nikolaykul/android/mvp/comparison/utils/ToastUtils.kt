package com.nikolaykul.android.mvp.comparison.utils

import android.content.Context
import android.support.annotation.StringRes
import es.dmoral.toasty.Toasty

/**
 * Created by nikolay
 */

object ToastUtils {

    fun showSuccess(ctx: Context, @StringRes stringRes: Int, duration: Int) {
        val msg = ctx.getString(stringRes)
        Toasty.success(ctx, msg, duration).show()
    }

    fun showError(ctx: Context, @StringRes stringRes: Int, duration: Int) {
        val msg = ctx.getString(stringRes)
        Toasty.error(ctx, msg, duration).show()
    }

}