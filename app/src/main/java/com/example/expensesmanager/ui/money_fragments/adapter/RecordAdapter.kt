package com.example.expensesmanager.ui.money_fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.R
import com.example.expensesmanager.models.Record

class RecordAdapter : RecyclerView.Adapter<RecordAdapter.RecordsViewHolder>() {

    class RecordsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.item_title)
        val moneyAmount: TextView = view.findViewById(R.id.item_money_amount)
        val description: TextView = view.findViewById(R.id.item_description)
    }

    private var recordList = emptyList<Record>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.record_item, parent, false)
        return RecordsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecordsViewHolder, position: Int) {
        holder.title.text = recordList[position].title
        holder.moneyAmount.text = recordList[position].moneyAmount.toString()
        holder.description.text = recordList[position].description
    }

    override fun getItemCount(): Int = recordList.size

    fun setList(list: List<Record>) {
        recordList = list
        notifyDataSetChanged()
    }
}
