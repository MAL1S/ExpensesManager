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
import com.example.expensesmanager.databinding.FragmentExpenseSourcesBinding
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.ui.MainViewModel
import com.example.expensesmanager.ui.money_fragments.adapter.SourceAdapter
import com.example.expensesmanager.utils.*

class IncomeSourcesFragment : Fragment() {

    private var _binding: FragmentExpenseSourcesBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mAdapter: SourceAdapter
    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mViewModel: MainViewModel
    private lateinit var mObserverList: Observer<List<Source>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentExpenseSourcesBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        init()
    }

    private fun init() {
        mRecyclerView = mBinding.recyclerView
        mAdapter = SourceAdapter()
        mRecyclerView.adapter = mAdapter

        mObserverList = Observer {
            log("income source $it")
            mAdapter.setList(it)
        }

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.incomeSources.observe(this, mObserverList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mViewModel.incomeSources.removeObserver(mObserverList)
    }

    companion object {
        fun click(source: Source) {
            CURRENT_SOURCE = source
            APP_ACTIVITY.navController.navigate(
                R.id.action_pageViewerSourceFragment_to_incomeRecordsFragment
            )
        }
    }
}