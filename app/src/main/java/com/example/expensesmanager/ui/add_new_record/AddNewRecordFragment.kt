package com.example.expensesmanager.ui.add_new_record

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.expensesmanager.R
import com.example.expensesmanager.databinding.FragmentAddNewRecordBinding
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.utils.*
import java.util.*


class AddNewRecordFragment : Fragment() {

    private var _binding: FragmentAddNewRecordBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mViewModel: AddNewRecordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddNewRecordBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        mViewModel = ViewModelProvider(this).get(AddNewRecordViewModel::class.java)

        initListeners()
    }

    private fun initListeners() {
        mBinding.buttonAddRecord.setOnClickListener {
            val src = CURRENT_SOURCE

            val type = src.category
            val source = src.source
            log("$type, $source")

            val id = src.id
            log("id = " + id.toString())

            if (id == -1) {
                showToast("error")
            } else {
                val title = mBinding.inputTitle.text.toString()
                val money = mBinding.inputMoney.text.toString().toInt()
                val desc = mBinding.inputDescription.text.toString()

                log(money.toString())

                if (type == EXPENSE) {
                    AppPreference.updateTotalMoney(-1 * money)
                    AppPreference.updateTotalExpensesMoney(money)
                } else {
                    AppPreference.updateTotalMoney(money)
                    AppPreference.updateTotalIncomeMoney(money)
                }

                val record = Record(
                    sourceId = id,
                    type = type,
                    title = title,
                    moneyAmount = money,
                    description = desc
                )

                log("record = " + record.toString())

                mViewModel.insert(
                    record
                ) {
                    mViewModel.updateMoney(id)
                    APP_ACTIVITY.navController.navigate(R.id.action_addNewRecordFragment_to_expenseRecordsFragment)
                }
            }
        }

        mBinding.datePicker.setOnClickListener {
            val c = Calendar.getInstance()
            val curYear = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(
                APP_ACTIVITY,
                { view, year, monthOfYear, dayOfMonth ->
                    mBinding.pickedDate.text = "$dayOfMonth:$monthOfYear:$year"
                },
                curYear,
                month,
                day
            )
            dpd.show()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}