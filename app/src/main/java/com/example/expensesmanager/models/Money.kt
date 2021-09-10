package com.example.expensesmanager.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "money_table")
data class Money(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo var type: String,
    @ColumnInfo var title: String,
    @ColumnInfo var moneyAmount: Int,
    var percent: Double = 0.0
)