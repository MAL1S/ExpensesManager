package com.example.expensesmanager.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.utils.EXPENSE
import com.example.expensesmanager.utils.INCOME

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM source_table")
    fun getAllItems(): LiveData<List<Source>>

    @Query("SELECT * FROM source_table WHERE category=:value")
    fun getAllExpensesSources(value: String = EXPENSE): LiveData<List<Source>>

    @Query("SELECT * FROM source_table WHERE category=:value")
    fun getAllIncomeSources(value: String = INCOME): LiveData<List<Source>>

    @Query("SELECT record_table.* FROM record_table JOIN source_table ON record_table.id = source_table.id WHERE source_table.category=:category AND source_table.source=:source GROUP BY record_table.moneyAmount")
    fun getAllFromSource(source: String, category: String): LiveData<List<Record>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(record: Record)

    @Delete
    suspend fun delete(record: Record)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(source: Source)

    @Delete
    suspend fun delete(source: Source)
}