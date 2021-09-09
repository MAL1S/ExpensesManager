package com.example.expensesmanager.models

import androidx.room.Entity

@Entity(tableName = "expenses_table")
data class Expense(
    var type: String,
    var moneyAmount: Int,
    var percent: Double
)