package com.example.expensesmanager.ui.add_new_type

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.expensesmanager.R
import com.example.expensesmanager.databinding.FragmentAddNewSourceBinding
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.utils.*

class AddNewSourceFragment : Fragment() {

    private var _binding: FragmentAddNewSourceBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mViewModel: AddNewSourceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddNewSourceBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        mViewModel = ViewModelProvider(this).get(AddNewSourceViewModel::class.java)

        init()
        initListeners()
    }

    private fun init() {

    }

    private fun initListeners() {
        mBinding.btnAddType.setOnClickListener {
            val s = mBinding.inputSource.text.toString()
            val t = if (CURRENT_TAB == 0) EXPENSE
            else INCOME
            mViewModel.insertSource(Source(source = s, category = t, year = AppPreference.getCurrentYear(), month = AppPreference.getCurrentMonth())) {
                APP_ACTIVITY.navController.navigate(R.id.action_addNewSourceFragment_to_pageViewerSourceFragment)
            }
        }
    }

    override fun onDestroy() {

        super.onDestroy()
    }
}