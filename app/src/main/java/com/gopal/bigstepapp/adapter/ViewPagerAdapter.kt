package com.gopal.bigstepapp.adapter

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter : FragmentPagerAdapter {

    private final var fragmentList: ArrayList<Fragment> = ArrayList()
    private final var fragmentTitleList: ArrayList<String> = ArrayList()

    public constructor(supportFragmentManager: FragmentManager)
            : super(supportFragmentManager)

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    // this function adds the fragment and title in 2 separate  arraylist.
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }
}