package com.example.expensesmanager.database

import androidx.lifecycle.LiveData
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.utils.EXPENSE
import com.example.expensesmanager.utils.INCOME

class AppRoomRepository(private val appRoomDao: AppRoomDao) {

    val allExpenseSources: LiveData<List<Source>>
        get() = appRoomDao.getAllExpensesSources()

    val allIncomeSources: LiveData<List<Source>>
        get() = appRoomDao.getAllIncomeSources()

    val allSources: List<Source>
        get() = appRoomDao.getById()

    val allRecords: List<Record>
        get() = appRoomDao.getAllRecords()

    val allExpenseRecords: LiveData<List<Record>>
        get() = appRoomDao.getAllFromSource(EXPENSE)

    val allIncomeRecords: LiveData<List<Record>>
        get() = appRoomDao.getAllFromSource(INCOME)

    suspend fun getAllSources(): List<Source> {
        return appRoomDao.getAllItems()
    }

    suspend fun getSourceId(category: String, source: String): List<Source> {
        return appRoomDao.getSourceId(category, source)
    }

    suspend fun insert(record: Record, onSuccess: () -> Unit) {
        appRoomDao.insert(record)
        onSuccess()
    }

    suspend fun delete(record: Record, onSuccess: () -> Unit) {
        appRoomDao.delete(record)
        onSuccess()
    }

    suspend fun insertSource(source: Source, onSuccess: () -> Unit) {
        appRoomDao.insert(source)
        onSuccess()
    }

    suspend fun deleteSource(source: Source, onSuccess: () -> Unit) {
        appRoomDao.delete(source)
        onSuccess()
    }
}