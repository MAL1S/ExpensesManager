package com.example.expensesmanager.utils

import android.util.Log
import android.widget.Toast
import com.example.expensesmanager.models.Record

fun showToast(msg: String) {
    Toast.makeText(APP_ACTIVITY, msg, Toast.LENGTH_SHORT).show()
}

fun sortByPercent(list: List<Record>): List<Record> {
    val res = list.sortedBy { it.moneyAmount }
    return res.reversed()
}

fun log(msg: String) {
    Log.d(LOG, msg)
}