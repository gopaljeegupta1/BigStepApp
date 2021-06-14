package com.gopal.bigstepapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.gopal.bigstepapp.R
import com.gopal.bigstepapp.adapter.ViewPagerAdapter
import com.gopal.bigstepapp.ui.tabs.ListFragment
import com.gopal.bigstepapp.ui.tabs.HistoryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabToolbar = findViewById<Toolbar>(R.id.toolbar)
        var tabTablayout = findViewById<TabLayout>(R.id.tab_tablayout)
        var tabViewpager = findViewById<ViewPager>(R.id.tab_viewpager)

        setSupportActionBar(tabToolbar)
        setupViewPager(tabViewpager)
        tabTablayout.setupWithViewPager(tabViewpager)

    }

    // This function is used to add items in arraylist and assign the adapter to view pager
    private fun setupViewPager(viewpager: ViewPager) {
        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(ListFragment(), "List")
        adapter.addFragment(HistoryFragment(), "History")

        // setting adapter to view pager.
        viewpager.setAdapter(adapter)
    }

}