package com.puresoftware.bottomnavigationappbar.Home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.puresoftware.bottomnavigationappbar.Home.category.*
import com.puresoftware.bottomnavigationappbar.Home.detail.DetailAskFragment
import com.puresoftware.bottomnavigationappbar.Home.detail.DetailReviewFragment
import com.puresoftware.bottomnavigationappbar.Home.detail.DetailSellInfoFragment
import com.puresoftware.bottomnavigationappbar.Home.detail.ProductInfoFragment

class DetailTabViewPagerAdapter (fragmentActivity: FragmentActivity,val list:List<String>): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ProductInfoFragment(list)
            1 -> DetailReviewFragment()
            2 -> DetailAskFragment()
            else -> DetailSellInfoFragment()
        }
    }
}