package com.example.expensesmanager.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "record_table")
data class Record(
    @PrimaryKey val id: Int,
    @ColumnInfo var type: String,
    @ColumnInfo var title: String,
    @ColumnInfo var moneyAmount: Int,
    @ColumnInfo var description: String
)