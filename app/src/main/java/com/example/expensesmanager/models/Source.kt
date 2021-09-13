package com.example.expensesmanager.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "source_table")
data class Source(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val source: String,
    @ColumnInfo val category: String,
    var totalMoneyAmount: Int = 0
)