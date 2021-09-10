package com.example.expensesmanager.ui.expenses_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.models.Money
import com.example.expensesmanager.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpenseFragmentViewModel: ViewModel() {

    val allExpenses = REPOSITORY.allExpenses
    val allIncome = REPOSITORY.allIncome
}