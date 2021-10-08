package com.example.expensesmanager.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.expensesmanager.R
import com.example.expensesmanager.databinding.ActivityMainBinding
import com.example.expensesmanager.models.Source
import com.example.expensesmanager.utils.APP_ACTIVITY
import com.example.expensesmanager.utils.AppPreference
import com.example.expensesmanager.utils.log
import com.example.expensesmanager.utils.months


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    lateinit var navController: NavController

    private lateinit var mViewModel: MainViewModel
    private lateinit var mObserverTotal: Observer<List<Source>>

    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mToolbar = mBinding.toolbar
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        init()
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

        mViewModel.expenseSources.observe(this, mObserverTotal)
        mViewModel.incomeSources.observe(this, mObserverTotal)

//        var observerTotal: Observer<List<Source>> = Observer {
//            log("$it")
//        }
//        mViewModel.allSources.observe(this, observerTotal)

        initToolbar()
    }

    private fun initToolbar() {
        val tv = mToolbar.findViewById<TextView>(R.id.tv_calendar)

        val updateText: () -> Unit = {
            tv.text = "${months[AppPreference.getCurrentMonth()]} ${AppPreference.getCurrentYear()}"
        }

        updateText()

        mToolbar.findViewById<Button>(R.id.btn_calendar_left).setOnClickListener {
            AppPreference.decCurrentMonth()
            updateText()
        }
        mToolbar.findViewById<Button>(R.id.btn_calendar_right).setOnClickListener {
            AppPreference.incCurrentMonth()
            updateText()
        }
    }

    override fun onResume() {
        super.onResume()

        mViewModel.expenseSources.observe(this, mObserverTotal)
        mViewModel.incomeSources.observe(this, mObserverTotal)
    }

    override fun onStop() {
        super.onStop()

        mViewModel.expenseSources.removeObservers(APP_ACTIVITY)
        mViewModel.incomeSources.removeObservers(APP_ACTIVITY)
    }

    override fun onDestroy() {
        _binding = null

        super.onDestroy()
    }
}