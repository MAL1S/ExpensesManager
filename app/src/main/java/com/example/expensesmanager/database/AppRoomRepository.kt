package com.example.expensesmanager.database

import androidx.lifecycle.LiveData
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.utils.CURRENT_SOURCE

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
        get() = appRoomDao.getAllFromSource(CURRENT_SOURCE.id)

    val allIncomeRecords: LiveData<List<Record>>
        get() = appRoomDao.getAllFromSource(CURRENT_SOURCE.id)

    val getAllSources: LiveData<List<Source>>
        get() = appRoomDao.getAllItems()


    suspend fun getSourceId(category: String, source: String): List<Source> {
        return appRoomDao.getSourceId(category, source)
    }

    suspend fun insert(record: Record) {
        appRoomDao.insert(record)
        //onSuccess()
    }

    suspend fun delete(record: Record, onSuccess: () -> Unit) {
        appRoomDao.delete(record)
        onSuccess()
    }

    suspend fun insertSource(source: Source) {
        appRoomDao.insert(source)
        //onSuccess()
    }

    suspend fun deleteSource(source: Source, onSuccess: () -> Unit) {
        appRoomDao.delete(source)
        onSuccess()
    }

    suspend fun updateTotalSourceMoney(total: Int, id: Int) {
        appRoomDao.updateTotalSourceMoney(total, id)
    }

    suspend fun getTotalSourceMoney(sourceId: Int): Int {
        return appRoomDao.getTotalSourceMoney(sourceId)
    }

    suspend fun getTotalMoney(): Int {
        return appRoomDao.getTotalMoney()
    }

    suspend fun getExpenseMoney(): Int {
        return appRoomDao.getTotalExpenseMoney()
    }

    suspend fun getIncomeMoney(): Int {
        return appRoomDao.getTotalIncomeMoney()
    }
}