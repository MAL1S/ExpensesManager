package com.example.expensesmanager.ui.add_new_record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewRecordViewModel: ViewModel() {

    fun insert(money: Record, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insert(money) {
                onSuccess()
            }
        }
    }
}