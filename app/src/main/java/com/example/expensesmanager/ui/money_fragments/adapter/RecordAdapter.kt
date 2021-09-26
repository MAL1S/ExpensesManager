package com.example.expensesmanager.ui.money_fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.R
import com.example.expensesmanager.models.Record
import com.example.expensesmanager.ui.money_fragments.expenses_fragment.ExpenseRecordsFragment
import com.example.expensesmanager.ui.money_fragments.expenses_fragment.ExpenseSourcesFragment
import com.example.expensesmanager.ui.money_fragments.income_fragment.IncomeRecordsFragment
import com.example.expensesmanager.ui.money_fragments.income_fragment.IncomeSourcesFragment
import com.example.expensesmanager.utils.CURRENT_RECORD
import com.example.expensesmanager.utils.CURRENT_SOURCE
import com.example.expensesmanager.utils.EXPENSE
import com.example.expensesmanager.utils.INCOME

class RecordAdapter : RecyclerView.Adapter<RecordAdapter.RecordsViewHolder>() {

    class RecordsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.item_title)
        val moneyAmount: TextView = view.findViewById(R.id.item_money_amount)
        val description: TextView = view.findViewById(R.id.item_description)
    }

    private var recordList = emptyList<Record>()

    override fun onViewAttachedToWindow(holder: RecordsViewHolder) {
        holder.itemView.setOnClickListener {
            val record = recordList[holder.adapterPosition]
            if (CURRENT_SOURCE.category == EXPENSE) ExpenseRecordsFragment.click(record)
            else if (CURRENT_SOURCE.category == INCOME) IncomeRecordsFragment.click(record)
        }
    }

    override fun onViewDetachedFromWindow(holder: RecordsViewHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.record_item, parent, false)
        return RecordsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecordsViewHolder, position: Int) {
        holder.title.text = recordList[position].title
        holder.moneyAmount.text = recordList[position].moneyAmount.toString()
        var desc = recordList[position].description
        if (desc.length > 39) {
            var newDesc = ""
            for (i in 0..37) newDesc += desc[i]
            newDesc += "..."
            desc = newDesc
        }
        holder.description.text = desc
    }

    override fun getItemCount(): Int = recordList.size

    fun setList(list: List<Record>) {
        recordList = list
        notifyDataSetChanged()
    }
}
