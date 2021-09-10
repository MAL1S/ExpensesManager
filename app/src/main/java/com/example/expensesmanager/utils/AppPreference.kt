package com.example.expensesmanager.utils

import android.content.Context
import android.content.SharedPreferences

object AppPreference {

    private const val TOTAL = "total"
    private const val TOTAL_EXPENSES = "total_expenses"
    private const val TOTAL_INCOME = "total_income"
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

    fun getTotalExpensesMoney(): Int = mPreferences.getInt(TOTAL_EXPENSES, 0)

    fun updateTotalExpensesMoney(value: Int) {
        mPreferences.edit()
            .putInt(TOTAL_EXPENSES, mPreferences.getInt(TOTAL_EXPENSES, 0) + value)
            .apply()
    }

    fun getTotalIncomeMoney(): Int = mPreferences.getInt(TOTAL_INCOME, 0)

    fun updateTotalIncomeMoney(value: Int) {
        mPreferences.edit()
            .putInt(TOTAL_INCOME, mPreferences.getInt(TOTAL_INCOME, 0) + value)
            .apply()
    }
}