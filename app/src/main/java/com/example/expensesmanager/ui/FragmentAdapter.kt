package com.example.expensesmanager.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.expensesmanager.ui.expenses_fragment.ExpensesFragment
import com.example.expensesmanager.ui.income_fragment.IncomeFragment

class FragmentAdapter(fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            1 -> return ExpensesFragment()
            2 -> return ExpensesFragment()
        }
        return ExpensesFragment()
    }
}