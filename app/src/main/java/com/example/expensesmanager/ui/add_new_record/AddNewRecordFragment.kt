package com.example.expensesmanager.ui.add_new_record

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.expensesmanager.databinding.FragmentAddNewRecordBinding
import com.example.expensesmanager.utils.APP_ACTIVITY
import com.example.expensesmanager.utils.showToast
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
        //для добавления записи,а не темы
//        mBinding.buttonAddRecord.setOnClickListener {
//            val type = if (CURRENT_TAB == 0) EXPENSE
//            else INCOME
//            val date = "today"
//            //val title = mBinding.inputTitle.text.toString()
//            //val money = mBinding.inputMoney.text.toString().toInt()
//
//            log(money.toString())
//
//            if (CURRENT_TAB == 0) {
//                AppPreference.updateTotalMoney(-1 * money)
//                AppPreference.updateTotalExpensesMoney(money)
//            } else {
//                AppPreference.updateTotalMoney(money)
//                AppPreference.updateTotalIncomeMoney(money)
//            }
//
//            showToast(AppPreference.getTotalExpensesMoney().toString())
//
//            mViewModel.insert(
//                Money(
//                    type = type,
//                    title = title,
//                    moneyAmount = money
//                )
//            ) {
//                APP_ACTIVITY.navController.navigate(R.id.action_addNewRecordFragment_to_pageViewerFragment)
//            }
//        }

        mBinding.datePicker.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            mBinding.datePicker.setOnClickListener {

                val dpd = DatePickerDialog(
                    APP_ACTIVITY,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        // Display Selected date in TextView
                        showToast("$dayOfMonth $monthOfYear, $year")
                    },
                    year,
                    month,
                    day
                )
                dpd.show()
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}