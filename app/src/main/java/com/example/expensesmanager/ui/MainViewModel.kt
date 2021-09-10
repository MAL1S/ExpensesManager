package com.example.expensesmanager.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.expensesmanager.database.AppRoomDatabase
import com.example.expensesmanager.database.AppRoomRepository
import com.example.expensesmanager.utils.AppPreference
import com.example.expensesmanager.utils.REPOSITORY

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val allExpenses
        get() = REPOSITORY.allExpenses
    val allIncome
        get() = REPOSITORY.allIncome

    val total: Int
        get() = AppPreference.getTotalMoney()

    private val mContext = application

    fun initDatabase() {
        val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
        REPOSITORY = AppRoomRepository(dao)
    }
}