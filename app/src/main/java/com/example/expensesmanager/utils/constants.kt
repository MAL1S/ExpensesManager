package com.example.expensesmanager.utils

import com.example.expensesmanager.database.AppRoomRepository
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.ui.MainActivity

const val LOG = "logd"
const val EXPENSE = "expense"
const val INCOME = "income"
lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: AppRoomRepository
var CURRENT_TAB: Int = 0
lateinit var CURRENT_SOURCE: Source
lateinit var CURRENT_RECORD: Record
val months = listOf<String>(
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
)