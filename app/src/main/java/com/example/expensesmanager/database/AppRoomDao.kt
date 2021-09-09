package com.example.expensesmanager.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.expensesmanager.models.Expense

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM expenses_table")
    fun getAllItems(): LiveData<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(expense: Expense)

    @Delete
    suspend fun delete(expense: Expense)
}