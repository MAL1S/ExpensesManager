package com.example.expensesmanager.ui.add_new_type

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.utils.REPOSITORY
import com.example.expensesmanager.utils.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewSourceViewModel : ViewModel() {

    fun insertSource(source: Source, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            log(source.id.toString())
            REPOSITORY.insertSource(source)
        }
        onSuccess()
    }
}
