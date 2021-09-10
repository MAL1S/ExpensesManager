package com.example.expensesmanager.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.expensesmanager.database.AppRoomDatabase
import com.example.expensesmanager.database.AppRoomRepository
import com.example.expensesmanager.utils.REPOSITORY

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application

    fun initDatabase() {
        val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
        REPOSITORY = AppRoomRepository(dao)
    }
}