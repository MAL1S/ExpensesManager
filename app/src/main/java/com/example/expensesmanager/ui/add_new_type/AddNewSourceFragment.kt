package com.example.expensesmanager.ui.add_new_type

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.expensesmanager.R
import com.example.expensesmanager.databinding.FragmentAddNewTypeBinding
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.utils.APP_ACTIVITY
import com.example.expensesmanager.utils.CURRENT_TAB
import com.example.expensesmanager.utils.EXPENSE
import com.example.expensesmanager.utils.INCOME

class AddNewSourceFragment : Fragment() {

    private var _binding: FragmentAddNewTypeBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mViewModel: AddNewSourceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddNewTypeBinding.inflate(layoutInflater, container, false)
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
            mViewModel.insertSource(Source(source = s, category = t)) {
                APP_ACTIVITY.navController.navigate(R.id.action_addNewTypeFragment_to_pageViewerFragment)
            }
        }
    }
}