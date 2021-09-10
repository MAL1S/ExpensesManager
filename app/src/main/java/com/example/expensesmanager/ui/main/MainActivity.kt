package com.example.expensesmanager.ui.main

import android.os.Bundle
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.expensesmanager.databinding.ActivityMainBinding
import com.example.expensesmanager.ui.FragmentAdapter
import com.example.expensesmanager.utils.APP_ACTIVITY
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mViewModel: MainViewModel

    private lateinit var tabLayout: TabLayout
    private lateinit var pager: ViewPager2
    private lateinit var adapter: FragmentAdapter
    private lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initViewPager()
        init()
    }

    private fun init() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.initDatabase()

        APP_ACTIVITY = this

    }

    private fun initViewPager() {
        tabLayout = mBinding.tabLayout
        pager = mBinding.viewPager

        fm = supportFragmentManager
        adapter = FragmentAdapter(fm, lifecycle)
        pager.adapter = adapter

        tabLayout.addTab(tabLayout.newTab().setText("Expenses"))
        tabLayout.addTab(tabLayout.newTab().setText("Income"))

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                pager.currentItem = tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
}