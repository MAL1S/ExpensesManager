package com.example.expensesmanager.utils

import android.widget.Toast
import com.example.expensesmanager.models.Money

fun showToast(msg: String) {
    Toast.makeText(APP_ACTIVITY, msg, Toast.LENGTH_SHORT).show()
}

fun sortByPercent(list: List<Money>): List<Money> {
    return list.sortedBy { it.percent }
}