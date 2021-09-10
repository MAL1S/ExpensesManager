package com.example.expensesmanager.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.expensesmanager.models.Money
import com.example.expensesmanager.utils.*

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM money_table")
    fun getAllItems(): LiveData<List<Money>>

    @Query("SELECT * FROM money_table WHERE type=:value")
    fun getAllExpenses(value: String = EXPENSE): LiveData<List<Money>>

    @Query("SELECT * FROM money_table WHERE type=:value")
    fun getAllIncome(value: String = INCOME): LiveData<List<Money>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(money: Money)

    @Delete
    suspend fun delete(money: Money)
}