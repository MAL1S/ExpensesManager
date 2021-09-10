package com.example.expensesmanager.database

import androidx.lifecycle.LiveData
import com.example.expensesmanager.models.Money

class AppRoomRepository(private val appRoomDao: AppRoomDao) {

    val allExpenses: LiveData<List<Money>>
        get() = appRoomDao.getAllExpenses()

    val allIncome: LiveData<List<Money>>
        get() = appRoomDao.getAllIncome()

    suspend fun insert(money: Money, onSuccess: () -> Unit) {
        appRoomDao.insert(money)
        onSuccess()
    }

    suspend fun delete(money: Money, onSuccess: () -> Unit) {
        appRoomDao.delete(money)
        onSuccess()
    }
}