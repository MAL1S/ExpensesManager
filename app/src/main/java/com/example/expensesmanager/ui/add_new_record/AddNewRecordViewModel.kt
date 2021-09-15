package com.example.expensesmanager.ui.add_new_record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.models.Source
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

    fun getRecords() {
        //insert(Record(1, "123", "123", 123, "123")) {}

        var res = emptyList<Record>()
        viewModelScope.launch(Dispatchers.IO) {
            res = withContext(Dispatchers.Default) {
                REPOSITORY.allRecords
            }
        }
        log("1 " + res)
    }
}