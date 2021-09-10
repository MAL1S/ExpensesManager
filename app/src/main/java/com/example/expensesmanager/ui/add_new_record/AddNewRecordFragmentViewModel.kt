package com.example.expensesmanager.ui.add_new_record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.models.Money
import com.example.expensesmanager.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewRecordFragmentViewModel: ViewModel() {

    fun insert(money: Money, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insert(money) {
                onSuccess()
            }
        }
    }
}