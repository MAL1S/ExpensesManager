package com.example.expensesmanager.ui.money_fragments

import androidx.lifecycle.ViewModel
import com.example.expensesmanager.utils.REPOSITORY

class MoneyViewModel: ViewModel() {

    val allExpenses = REPOSITORY.allExpenses
    val allIncome = REPOSITORY.allIncome
}