package com.example.expensesmanager.ui.money_fragments.expenses_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.databinding.FragmentExpensesBinding
import com.example.expensesmanager.models.Money
import com.example.expensesmanager.ui.MainViewModel
import com.example.expensesmanager.ui.money_fragments.MoneyAdapter
import com.example.expensesmanager.utils.LOG
import com.example.expensesmanager.utils.sortByPercent

class ExpensesFragment : Fragment() {

    private var _binding: FragmentExpensesBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mAdapter: MoneyAdapter
    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mViewModel: MainViewModel
    private lateinit var mObserverList: Observer<List<Money>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExpensesBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        mRecyclerView = mBinding.recyclerView
        mAdapter = MoneyAdapter()
        mRecyclerView.adapter = mAdapter

        mObserverList = Observer {
            val list = sortByPercent(it)
            mAdapter.setList(list)
            Log.d(LOG, "observed expenses")
        }

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.allExpenses.observe(this, mObserverList)
    }
}