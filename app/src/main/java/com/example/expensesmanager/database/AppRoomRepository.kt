package com.example.expensesmanager.database

import androidx.lifecycle.LiveData
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.models.Source

class AppRoomRepository(private val appRoomDao: AppRoomDao) {

    val allExpenseSources: LiveData<List<Source>>
        get() = appRoomDao.getAllExpensesSources()

    val allIncomeSources: LiveData<List<Source>>
        get() = appRoomDao.getAllIncomeSources()

    val allSources: LiveData<List<Source>>
        get() = appRoomDao.getAllItems()

//    val allExpenseRecords: LiveData<List<Record>>
//        get() = appRoomDao.getAllFromSource()
//
//    val allExpenseRecords: LiveData<List<Record>>
//        get() = appRoomDao.getAllFromSource()

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