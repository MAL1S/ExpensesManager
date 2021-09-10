package com.example.expensesmanager.ui.page_viewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.expensesmanager.databinding.FragmentPageViewerBinding
import com.example.expensesmanager.ui.page_viewer.FragmentAdapter
import com.example.expensesmanager.utils.APP_ACTIVITY
import com.example.expensesmanager.utils.CURRENT_TAB
import com.example.expensesmanager.utils.log
import com.google.android.material.tabs.TabLayout

class PageViewerFragment : Fragment() {

    private var _binding: FragmentPageViewerBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var tabLayout: TabLayout
    private lateinit var pager: ViewPager2
    private lateinit var adapter: FragmentAdapter
    private lateinit var fm: FragmentManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPageViewerBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        initViewPager()
    }

    private fun initViewPager() {
        tabLayout = mBinding.tabLayout
        pager = mBinding.viewPager

        fm = APP_ACTIVITY.supportFragmentManager
        adapter = FragmentAdapter(fm, lifecycle)
        pager.adapter = adapter

        tabLayout.addTab(tabLayout.newTab().setText("Expenses"))
        tabLayout.addTab(tabLayout.newTab().setText("Income"))

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                pager.currentItem = tab?.position!!
                CURRENT_TAB =  tab.position
                log(CURRENT_TAB.toString())
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