package com.example.expensesmanager.utils

import android.util.Log
import android.widget.Toast
import com.example.expensesmanager.models.Record

fun showToast(msg: String) {
    Toast.makeText(APP_ACTIVITY, msg, Toast.LENGTH_SHORT).show()
}

fun log(msg: String) {
    Log.d(LOG, msg)
}