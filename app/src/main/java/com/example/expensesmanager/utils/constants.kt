package com.example.expensesmanager.utils

import com.example.expensesmanager.database.AppRoomRepository
import com.example.expensesmanager.ui.main.MainActivity

const val LOG = "logd"
const val EXPENSE = "expense"
const val INCOME = "income"
lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: AppRoomRepository