package com.example.expensesmanager.ui.add_new_record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.expensesmanager.R
import com.example.expensesmanager.databinding.FragmentAddNewRecordBinding
import com.example.expensesmanager.models.Money
import com.example.expensesmanager.ui.expenses_fragment.ExpenseFragmentViewModel
import com.example.expensesmanager.utils.APP_ACTIVITY
import com.example.expensesmanager.utils.EXPENSE

class AddNewRecordFragment : Fragment() {

    private var _binding: FragmentAddNewRecordBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mViewModel: AddNewRecordFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddNewRecordBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        mViewModel = ViewModelProvider(this).get(AddNewRecordFragmentViewModel::class.java)

        initListeners()
    }

    private fun initListeners() {
        mBinding.buttonAddRecord.setOnClickListener {
            val type = EXPENSE
            val date = "today"
            val title = mBinding.inputTitle.text.toString()
            val money = mBinding.inputMoney.text.toString().toInt()

            mViewModel.insert(Money(
                type = type,
                title = title,
                moneyAmount = money
            )) {
                APP_ACTIVITY.navController.navigate(R.id.action_addNewRecordFragment_to_pageViewerFragment)
            }
        }
    }
}