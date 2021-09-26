package com.example.expensesmanager.ui.money_fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.Guideline
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.R
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.ui.money_fragments.expenses_fragment.ExpenseSourcesFragment
import com.example.expensesmanager.ui.money_fragments.income_fragment.IncomeSourcesFragment
import com.example.expensesmanager.utils.AppPreference
import com.example.expensesmanager.utils.EXPENSE
import com.example.expensesmanager.utils.INCOME
import com.example.expensesmanager.utils.log

class SourceAdapter : RecyclerView.Adapter<SourceAdapter.SourcesViewHolder>() {

    class SourcesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.item_title)
        val filler: Guideline = view.findViewById(R.id.filling_guideline)
        val moneyAmount: TextView = view.findViewById(R.id.item_money_amount)
        val percent: TextView = view.findViewById(R.id.item_description)
    }

    private var mSourcesList = emptyList<Source>()

    override fun onViewAttachedToWindow(holder: SourcesViewHolder) {
        holder.itemView.setOnClickListener {
            val src = mSourcesList[holder.adapterPosition]
            if (src.category == EXPENSE) ExpenseSourcesFragment.click(src)
            else if (src.category == INCOME) IncomeSourcesFragment.click(src)
        }
    }

    override fun onViewDetachedFromWindow(holder: SourcesViewHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.source_item, parent, false)
        return SourcesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SourcesViewHolder, position: Int) {
        holder.title.text = mSourcesList[position].source
        if (mSourcesList[position].category == EXPENSE) {
            holder.filler.setGuidelinePercent(1f * mSourcesList[position].totalMoneyAmount / AppPreference.getTotalExpensesMoney())
            holder.percent.text =
                (100f * mSourcesList[position].totalMoneyAmount / AppPreference.getTotalExpensesMoney()).toInt()
                    .toString()
            //log(AppPreference.getTotalExpensesMoney().toString())
        } else {
            holder.filler.setGuidelinePercent(1f * mSourcesList[position].totalMoneyAmount / AppPreference.getTotalIncomeMoney())
            holder.percent.text =
                (100f * mSourcesList[position].totalMoneyAmount / AppPreference.getTotalIncomeMoney()).toInt()
                    .toString()
            //log(AppPreference.getTotalIncomeMoney().toString())
        }
        holder.moneyAmount.text = mSourcesList[position].totalMoneyAmount.toString()
    }

    override fun getItemCount(): Int = mSourcesList.size

    fun setList(list: List<Source>) {
        mSourcesList = list
        notifyDataSetChanged()
    }
}
