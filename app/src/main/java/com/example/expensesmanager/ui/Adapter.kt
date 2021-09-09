package com.example.expensesmanager.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.Guideline
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.R
import com.example.expensesmanager.models.Expense
import kotlinx.android.synthetic.main.list_item.view.*
import kotlin.math.roundToInt

class Adapter: RecyclerView.Adapter<ExpensesViewHolder>() {

    private var mExpensesList = emptyList<Expense>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ExpensesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        holder.filler.setGuidelinePercent(mExpensesList[position].percent.roundToInt() / 100f)
        holder.moneyAmount.text = mExpensesList[position].moneyAmount.toString()
        holder.percent.text = mExpensesList[position].percent.toString()
    }

    override fun getItemCount(): Int = mExpensesList.size

    fun setList(list: List<Expense>) {
        mExpensesList = list
        notifyDataSetChanged()
    }
}

class ExpensesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val filler: Guideline = view.filling_guideline
    val moneyAmount: TextView = view.item_money_amount
    val percent: TextView = view.item_percentage
}