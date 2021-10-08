package com.example.expensesmanager.utils

import android.content.Context
import android.content.SharedPreferences
import java.util.*

object AppPreference {

    private const val TOTAL = "total"
    private const val TOTAL_EXPENSES = "total_expenses"
    private const val TOTAL_INCOME = "total_income"
    private const val NAME_PREF = "preference"
    private const val CURRENT_YEAR = "current_year"
    private const val CURRENT_MONTH = "current_month"

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

    fun getCurrentYear(): Int = mPreferences.getInt(CURRENT_YEAR, Calendar.getInstance().get(Calendar.YEAR))

    private fun incCurrentYear() {
        val curYear = getCurrentYear() + 1

        mPreferences.edit()
            .putInt(CURRENT_YEAR, curYear)
            .apply()
    }

    private fun decCurrentYear() {
        val curYear = getCurrentYear() - 1

        mPreferences.edit()
            .putInt(CURRENT_YEAR, curYear)
            .apply()
    }

    fun getCurrentMonth(): Int = mPreferences.getInt(CURRENT_MONTH, Calendar.getInstance().get(Calendar.MONTH))

    fun incCurrentMonth() {
        var curMonth = mPreferences.getInt(CURRENT_MONTH, Calendar.getInstance().get(Calendar.MONTH)) + 1
        if (curMonth == 12) {
            curMonth = 0
            incCurrentYear()
        }

        mPreferences.edit()
            .putInt(CURRENT_MONTH, curMonth)
            .apply()
    }

    fun decCurrentMonth() {
        var curMonth = mPreferences.getInt(CURRENT_MONTH, Calendar.getInstance().get(Calendar.MONTH)) - 1
        if (curMonth == -1) {
            curMonth = 11
            decCurrentYear()
        }

        mPreferences.edit()
            .putInt(CURRENT_MONTH, curMonth)
            .apply()
    }
}