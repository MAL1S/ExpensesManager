package com.example.expensesmanager.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.expensesmanager.R
import com.example.expensesmanager.databinding.ActivityMainBinding
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.utils.*

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    lateinit var navController: NavController

    private lateinit var mViewModel: MainViewModel
    private lateinit var mObserverTotal: Observer<List<Source>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        init()
        initListeners()
    }

    private fun init() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.initDatabase()

        APP_ACTIVITY = this

        navController = findNavController(R.id.nav_host_fragment)

        AppPreference.getPreference(this)

        mBinding.total.text = AppPreference.getTotalMoney().toString()
        mBinding.totalExpenses.text = AppPreference.getTotalExpensesMoney().toString()
        mBinding.totalIncome.text = AppPreference.getTotalIncomeMoney().toString()

        mObserverTotal = Observer {
            mBinding.total.text = mViewModel.total.toString()
            mBinding.totalExpenses.text = mViewModel.totalExpenses.toString()
            mBinding.totalIncome.text = mViewModel.totalIncome.toString()
        }

        //mViewModel.allExpenses.observe(this, mObserverTotal)
        //mViewModel.allIncome.observe(this, mObserverTotal)
    }

    private fun initListeners() {
        mBinding.fab.setOnClickListener {
            //navController.navigate(R.id.action_pageViewerFragment_to_addNewTypeFragment)
        }
    }

    override fun onResume() {
        super.onResume()

        log("resumed")
    }

    override fun onDestroy() {
        _binding = null
        //mViewModel.allExpenses.removeObservers(APP_ACTIVITY)
        super.onDestroy()
    }
}