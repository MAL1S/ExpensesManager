package com.example.expensesmanager.utils

import android.util.Log
import android.widget.Toast
import com.example.expensesmanager.models.Money

fun showToast(msg: String) {
    Toast.makeText(APP_ACTIVITY, msg, Toast.LENGTH_SHORT).show()
}

fun sortByPercent(list: List<Money>): List<Money> {
    val res = list.sortedBy { it.moneyAmount }
    return res.reversed()
}

fun log(msg: String) {
    Log.d(LOG, msg)
}