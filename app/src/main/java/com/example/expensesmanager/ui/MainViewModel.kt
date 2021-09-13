package com.example.expensesmanager.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.expensesmanager.database.AppRoomDatabase
import com.example.expensesmanager.database.AppRoomRepository
import com.example.expensesmanager.utils.AppPreference
import com.example.expensesmanager.utils.REPOSITORY

class MainViewModel(application: Application) : AndroidViewModel(application) {

//    val allExpenses
//        get() = REPOSITORY.allExpenses
//    val allIncome
//        get() = REPOSITORY.allIncome

    val expenseSources
        get() = REPOSITORY.allExpenseSources

    val incomeSources
        get() = REPOSITORY.allIncomeSources

    val total: Int
        get() = AppPreference.getTotalMoney()

    val totalExpenses: Int
        get() = AppPreference.getTotalExpensesMoney()

    val totalIncome: Int
        get() = AppPreference.getTotalIncomeMoney()

    private val mContext = application

    fun initDatabase() {
        val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
        REPOSITORY = AppRoomRepository(dao)
    }
}