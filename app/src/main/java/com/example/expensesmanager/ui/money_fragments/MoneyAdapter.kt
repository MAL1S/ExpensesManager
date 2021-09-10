package com.example.expensesmanager.ui.money_fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.Guideline
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.R
import com.example.expensesmanager.models.Money
import com.example.expensesmanager.utils.AppPreference
import com.example.expensesmanager.utils.LOG
import com.example.expensesmanager.utils.log
import kotlinx.android.synthetic.main.list_item.view.*
import kotlin.math.roundToInt

class MoneyAdapter : RecyclerView.Adapter<MoneyAdapter.ExpensesViewHolder>() {

    class ExpensesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.title
        val filler: Guideline = view.filling_guideline
        val moneyAmount: TextView = view.item_money_amount
        val percent: TextView = view.item_percentage
    }

    private var mExpensesList = emptyList<Money>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ExpensesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        holder.title.text = mExpensesList[position].title
        holder.filler.setGuidelinePercent(1f*mExpensesList[position].moneyAmount / AppPreference.getTotalMoney())
        log((1f*mExpensesList[position].moneyAmount / AppPreference.getTotalMoney()).toString())
        holder.moneyAmount.text = mExpensesList[position].moneyAmount.toString()
        holder.percent.text = (100f * mExpensesList[position].moneyAmount / AppPreference.getTotalMoney()).toInt().toString()
    }

    override fun getItemCount(): Int = mExpensesList.size

    fun setList(list: List<Money>) {
        mExpensesList = list
        notifyDataSetChanged()
    }
}
