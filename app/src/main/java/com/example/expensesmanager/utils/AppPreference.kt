package com.example.expensesmanager.utils

import android.content.Context
import android.content.SharedPreferences

object AppPreference {

    private const val TOTAL = "total"
    private const val NAME_PREF = "preference"

    private lateinit var mPreferences: SharedPreferences

    fun getPreference(context: Context): SharedPreferences {
        mPreferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
        return mPreferences
    }

    fun getTotalMoney(): Int = mPreferences.getInt(TOTAL, 0)

    fun updateTotalMoney(value: Int) {
        mPreferences.edit()
            .putInt(TOTAL, mPreferences.getInt(TOTAL, 0) + value)
            .apply()
    }
}