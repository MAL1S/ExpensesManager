package com.example.expensesmanager.ui.money_fragments.income_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.databinding.FragmentIncomeBinding
import com.example.expensesmanager.models.Money
import com.example.expensesmanager.ui.money_fragments.MoneyViewModel
import com.example.expensesmanager.ui.money_fragments.MoneyAdapter
import com.example.expensesmanager.utils.LOG
import com.example.expensesmanager.utils.log
import com.example.expensesmanager.utils.sortByPercent

class IncomeFragment : Fragment() {

    private var _binding: FragmentIncomeBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mAdapter: MoneyAdapter
    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mViewModel: MoneyViewModel
    private lateinit var mObserverList: Observer<List<Money>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentIncomeBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        mViewModel = ViewModelProvider(this).get(MoneyViewModel::class.java)

        mRecyclerView = mBinding.recyclerView
        mAdapter = MoneyAdapter()
        mRecyclerView.adapter = mAdapter

        mObserverList = Observer {
            val list = sortByPercent(it)
            mAdapter.setList(list)
            log(list.toString())
            Log.d(LOG, "observed income")
        }


        mViewModel.allIncome.observe(this, mObserverList)
    }
}