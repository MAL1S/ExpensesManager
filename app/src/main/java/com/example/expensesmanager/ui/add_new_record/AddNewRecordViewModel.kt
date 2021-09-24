package com.example.expensesmanager.ui.add_new_record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.utils.AppPreference
import com.example.expensesmanager.utils.REPOSITORY
import com.example.expensesmanager.utils.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNewRecordViewModel : ViewModel() {

    fun insert(record: Record, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insert(record) {
                onSuccess()
            }
        }
    }

//    fun getId(category: String, source: String): List<Source> {
//
////        var res = emptyList<Source>()
////        viewModelScope.launch(Dispatchers.IO) {
////
////        }
//        return
//    }

    fun updateMoney(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val totalSource = REPOSITORY.getTotalSourceMoney(id)
            val total = REPOSITORY.getTotalMoney()
            val totalExpense = REPOSITORY.getExpenseMoney()
            val totalIncome = REPOSITORY.getIncomeMoney()

            log("total = $total")
            log("totalExpense = $totalExpense")
            log("totalIncome = $totalIncome")
            log("totalSource = $totalSource")

            REPOSITORY.updateTotalSourceMoney(totalSource, id)

            withContext(Dispatchers.Main) {
                AppPreference.updateTotalMoney(total)
                AppPreference.updateTotalExpensesMoney(totalExpense)
                AppPreference.updateTotalIncomeMoney(totalIncome)
            }
        }
    }
}
