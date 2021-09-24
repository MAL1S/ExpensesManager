package com.example.expensesmanager.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.utils.EXPENSE
import com.example.expensesmanager.utils.INCOME

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM Source")
    fun getAllItems(): List<Source>

    @Query("SELECT * FROM record_table")
    fun getAllRecords(): List<Record>

    @Query("SELECT * FROM Source")
    fun getById(): List<Source>

    @Query("UPDATE source SET totalMoneyAmount=:total WHERE id=:id")
    fun updateTotalSourceMoney(total: Int, id: Int)

    @Query("SELECT SUM(moneyAmount) FROM record_table WHERE sourceId=:id")
    fun getTotalSourceMoney(id: Int): Int

    @Query("SELECT SUM(moneyAmount) FROM record_table")
    fun getTotalMoney(): Int

    @Query("SELECT SUM(moneyAmount) FROM record_table JOIN Source ON record_table.sourceId = Source.id WHERE Source.category=:cat")
    fun getTotalExpenseMoney(cat: String = EXPENSE): Int

    @Query("SELECT SUM(moneyAmount) FROM record_table JOIN Source ON record_table.sourceId = Source.id WHERE Source.category=:cat")
    fun getTotalIncomeMoney(cat: String = INCOME): Int

    @Query("SELECT * FROM Source WHERE category=:value")
    fun getAllExpensesSources(value: String = EXPENSE): LiveData<List<Source>>

    @Query("SELECT * FROM Source WHERE category=:value")
    fun getAllIncomeSources(value: String = INCOME): LiveData<List<Source>>

    @Query("SELECT record_table.* FROM record_table JOIN Source ON record_table.sourceId = Source.id WHERE Source.id = :id GROUP BY record_table.moneyAmount")
    fun getAllFromSource(id: Int): LiveData<List<Record>>

    @Query("SELECT * FROM Source WHERE Source=:category AND Source=:source")
    suspend fun getSourceId(category: String, source: String): List<Source>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(record: Record)

    @Delete
    suspend fun delete(record: Record)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(source: Source)

    @Delete
    suspend fun delete(source: Source)
}