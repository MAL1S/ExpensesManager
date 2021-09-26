package com.example.expensesmanager.ui.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.expensesmanager.databinding.FragmentRecordBinding
import com.example.expensesmanager.utils.CURRENT_RECORD

class RecordFragment : Fragment() {

    private var _binding: FragmentRecordBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var title: TextView
    private lateinit var moneyCount: TextView
    private lateinit var description: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRecordBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        init()

        val record = CURRENT_RECORD

        title.text = record.title
        moneyCount.text = record.moneyAmount.toString()
        description.text = record.description
    }

    private fun init() {
        title = mBinding.tvRecordTitle
        moneyCount = mBinding.tvMoneyCount
        description = mBinding.tvDescription
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}