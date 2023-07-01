package com.puresoftware.bottomnavigationappbar.Home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.puresoftware.bottomnavigationappbar.Home.category.AllFragment
import com.puresoftware.bottomnavigationappbar.Home.category.BeautyFragment
import com.puresoftware.bottomnavigationappbar.Home.category.FashionFragment
import com.puresoftware.bottomnavigationappbar.Home.category.FoodFragment
import com.puresoftware.bottomnavigationappbar.Home.category.InteriorFragment
import com.puresoftware.bottomnavigationappbar.Home.category.LivingFragment
import com.puresoftware.bottomnavigationappbar.Home.category.PetFragment
import com.puresoftware.bottomnavigationappbar.Home.groupbuy.GroupbuyFragment


class GroupbuyViewpagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> GroupbuyFragment("twoGroupBuy")
            1 -> GroupbuyFragment("fiveGroupBuy")
            else -> GroupbuyFragment("tenGroupBuy")
        }
    }
}