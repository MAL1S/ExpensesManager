package com.example.expensesmanager.ui.page_viewer.source

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.expensesmanager.R
import com.example.expensesmanager.databinding.ActivityMainBinding
import com.example.expensesmanager.databinding.FragmentPageViewerSourceBinding
import com.example.expensesmanager.utils.APP_ACTIVITY
import com.example.expensesmanager.utils.CURRENT_TAB
import com.example.expensesmanager.utils.log
import com.google.android.material.tabs.TabLayout

class PageViewerSourceFragment : Fragment() {

    private var _binding: FragmentPageViewerSourceBinding? = null
    private var mainBinding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var tabLayout: TabLayout
    private lateinit var pager: ViewPager2
    private lateinit var adapter: FragmentSourceAdapter
    private lateinit var fm: FragmentManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPageViewerSourceBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        initViewPager()
        initListeners()
    }

    private fun initViewPager() {
        tabLayout = mBinding.tabLayout
        pager = mBinding.viewPager

        fm = APP_ACTIVITY.supportFragmentManager
        adapter = FragmentSourceAdapter(fm, lifecycle)
        if (pager.adapter == null) {
            pager.adapter = adapter
            tabLayout.addTab(tabLayout.newTab().setText("Expenses"))
            tabLayout.addTab(tabLayout.newTab().setText("Income"))
            pager.isSaveEnabled = false
        }

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                pager.currentItem = tab?.position!!
                CURRENT_TAB =  tab.position
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

    private fun initListeners() {
        mBinding.fab.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_pageViewerSourceFragment_to_addNewSourceFragment)
        }
    }

    override fun onDestroyView() {
        _binding = null
        pager.adapter = null
        super.onDestroyView()
    }
}