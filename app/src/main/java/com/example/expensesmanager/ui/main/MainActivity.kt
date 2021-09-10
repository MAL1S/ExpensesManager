package com.example.expensesmanager.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.expensesmanager.R
import com.example.expensesmanager.databinding.ActivityMainBinding
import com.example.expensesmanager.utils.APP_ACTIVITY
import com.example.expensesmanager.utils.LOG
import com.example.expensesmanager.utils.log

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    lateinit var navController: NavController

    private lateinit var mViewModel: MainViewModel


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
    }

    private fun initListeners() {
        mBinding.fab.setOnClickListener {

            navController.navigate(R.id.action_pageViewerFragment_to_addNewRecordFragment)
//            mBinding.fab.visibility = View.GONE
//            mBinding.bottomInfo.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()

        log("resumed")

//        mBinding.fab.visibility = View.VISIBLE
//        mBinding.bottomInfo.visibility = View.VISIBLE
    }
}