package com.example.expensesmanager.ui.add_new_type

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewSourceViewModel: ViewModel() {

    fun insertSource(source: Source, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertSource(source) {
                onSuccess()
            }
        }
    }
}