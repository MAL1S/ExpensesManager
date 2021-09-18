package com.example.expensesmanager.ui.money_fragments.income_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.R
import com.example.expensesmanager.databinding.FragmentIncomeRecordsBinding
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.ui.MainViewModel
import com.example.expensesmanager.ui.money_fragments.adapter.RecordAdapter
import com.example.expensesmanager.utils.APP_ACTIVITY
import com.example.expensesmanager.utils.LOG
import com.example.expensesmanager.utils.log
import com.example.expensesmanager.utils.sortByPercent

class IncomeRecordsFragment : Fragment() {

    private var _binding: FragmentIncomeRecordsBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mAdapter: RecordAdapter
    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mViewModel: MainViewModel
    private lateinit var mObserverList: Observer<List<Record>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentIncomeRecordsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        mRecyclerView = mBinding.recyclerView
        mAdapter = RecordAdapter()
        mRecyclerView.adapter = mAdapter

        mObserverList = Observer {
            mAdapter.setList(it.reversed())
        }

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.incomeRecords.observe(APP_ACTIVITY, mObserverList)

        mBinding.fab.setOnClickListener {
            //val bundle = Bundle()
            //bundle.putSerializable("source", arguments?.getSerializable("source"))
            //log(arguments?.getSerializable("source").toString())
            APP_ACTIVITY.navController.navigate(
                R.id.action_incomeRecordsFragment_to_addNewRecordFragment
            )
        }
    }

    override fun onDestroy() {
        _binding = null
        //mViewModel.allExpenses.removeObservers(APP_ACTIVITY)
        super.onDestroy()
    }
}