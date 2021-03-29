package com.muratcanapps.mvp_login_screen.extentions

import android.content.Context
import android.widget.Toast
import java.util.regex.Pattern

fun Any?.isNull() = this == null

fun String.isEmailFormatValid(): Boolean {
    val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()