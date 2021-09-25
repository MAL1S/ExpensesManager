package com.example.expensesmanager.ui.add_new_record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.utils.*
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

    fun updateMoney(id: Int, moneyAmount: Int, category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val totalSource = REPOSITORY.getTotalSourceMoney(id)
            //val total = REPOSITORY.getTotalMoney()
//            val totalExpense = REPOSITORY.getExpenseMoney()
//            val totalIncome = REPOSITORY.getIncomeMoney()

            //log("total = $total")
//            log("totalExpense = $totalExpense")
//            log("totalIncome = $totalIncome")

            REPOSITORY.updateTotalSourceMoney(totalSource, id)

            withContext(Dispatchers.Main) {
//                log(category)
//                log("money = $moneyAmount")
//                if (category == EXPENSE) {
//                    AppPreference.updateTotalMoney(-1*moneyAmount)
//                    AppPreference.updateTotalExpensesMoney(moneyAmount)
//                }
//                else if (category == INCOME) {
//                    AppPreference.updateTotalMoney(moneyAmount)
//                    AppPreference.updateTotalIncomeMoney(moneyAmount)
//                    log("updated = " + AppPreference.getTotalIncomeMoney())
//                }
            }
        }
    }
}
