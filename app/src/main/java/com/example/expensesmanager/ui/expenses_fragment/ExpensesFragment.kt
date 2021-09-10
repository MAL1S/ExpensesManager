package com.example.expensesmanager.ui.expenses_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.databinding.FragmentExpensesBinding
import com.example.expensesmanager.models.Money
import com.example.expensesmanager.utils.*

class ExpensesFragment : Fragment() {

    private var _binding: FragmentExpensesBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mAdapter: ExpensesAdapter
    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mViewModel: ExpenseFragmentViewModel
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
        mAdapter = ExpensesAdapter()
        mRecyclerView.adapter = mAdapter


        mObserverList = Observer {
            val list = sortByPercent(it)
            mAdapter.setList(list)
            Log.d(LOG, "observed")
        }

        mViewModel = ViewModelProvider(this).get(ExpenseFragmentViewModel::class.java)
        mViewModel.allExpenses.observe(this, mObserverList)
//        mViewModel.insert(Money(type = EXPENSE, title = "Eda", moneyAmount = 100)) {
//            Log.d(LOG, "inserted")
//        }
    }
}