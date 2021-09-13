package com.example.expensesmanager.ui.money_fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.R
import com.example.expensesmanager.models.Record

class RecordAdapter : RecyclerView.Adapter<RecordAdapter.RecordsViewHolder>() {

    class RecordsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val title: TextView = view.title
//        val filler: Guideline = view.filling_guideline
//        val moneyAmount: TextView = view.item_money_amount
//        val percent: TextView = view.item_percentage
    }

    private var mExpensesList = emptyList<Record>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.source_item, parent, false)
        return RecordsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecordsViewHolder, position: Int) {
//        holder.title.text = mExpensesList[position].title
//        if (mExpensesList[position].type == EXPENSE) {
//            holder.filler.setGuidelinePercent(1f * mExpensesList[position].moneyAmount / AppPreference.getTotalExpensesMoney())
//            holder.percent.text = (100f * mExpensesList[position].moneyAmount / AppPreference.getTotalExpensesMoney()).toInt().toString()
//            log(AppPreference.getTotalExpensesMoney().toString())
//        }
//        else {
//            holder.filler.setGuidelinePercent(1f * mExpensesList[position].moneyAmount / AppPreference.getTotalIncomeMoney())
//            holder.percent.text = (100f * mExpensesList[position].moneyAmount / AppPreference.getTotalIncomeMoney()).toInt().toString()
//            log(AppPreference.getTotalIncomeMoney().toString())
//        }
//        holder.moneyAmount.text = mExpensesList[position].moneyAmount.toString()
    }

    override fun getItemCount(): Int = mExpensesList.size

    fun setList(list: List<Record>) {
        mExpensesList = list
        notifyDataSetChanged()
    }
}
