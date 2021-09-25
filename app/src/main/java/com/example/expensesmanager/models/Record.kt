package com.example.expensesmanager.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "record_table")
data class Record(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo val sourceId: Int,
    @ColumnInfo var type: String,
    @ColumnInfo var title: String,
    @ColumnInfo var moneyAmount: Int,
    @ColumnInfo var description: String
): Serializable