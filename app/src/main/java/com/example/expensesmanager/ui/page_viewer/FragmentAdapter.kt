package com.example.expensesmanager.ui.page_viewer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.expensesmanager.ui.money_fragments.expenses_fragment.ExpenseRecordsFragment
import com.example.expensesmanager.ui.money_fragments.expenses_fragment.ExpenseSourcesFragment
import com.example.expensesmanager.ui.money_fragments.income_fragment.IncomeRecordsFragment
import com.example.expensesmanager.ui.money_fragments.income_fragment.IncomeSourcesFragment

class FragmentAdapter(fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ExpenseSourcesFragment()
            1 -> return IncomeSourcesFragment()
        }
        return ExpenseSourcesFragment()
    }
}