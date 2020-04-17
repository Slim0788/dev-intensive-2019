package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager


fun Activity.hideKeyboard() {
    val focus = currentFocus
    if (focus != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(focus.windowToken, 0)
    }
}

fun Activity.isKeyboardOpen(): Boolean {
    return false
}

fun Activity.isKeyboardClosed(): Boolean {
    return false
}