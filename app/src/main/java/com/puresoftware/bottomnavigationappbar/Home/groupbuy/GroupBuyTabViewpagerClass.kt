package com.puresoftware.bottomnavigationappbar.Home.groupbuy

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.puresoftware.bottomnavigationappbar.Home.adapter.GroupbuyViewpagerAdapter
import com.puresoftware.bottomnavigationappbar.MainActivity
import com.puresoftware.bottomnavigationappbar.Server.MasterApplication
import com.puresoftware.bottomnavigationappbar.databinding.FragmentCategoryBinding


class GroupBuyTabViewpagerClass : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private val tabList = listOf("2인 공구","5인 공구","10인 공구")
    private lateinit var mainActivity: MainActivity
    private lateinit var wegglerApp : MasterApplication

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
        wegglerApp = mainActivity.masterApp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater,container,false)
        binding.categoryTabViewpager.adapter = GroupbuyViewpagerAdapter(activity as MainActivity)

        TabLayoutMediator(binding.categoryTab,binding.categoryTabViewpager){ tab, pos ->
            tab.text = tabList[pos]
        }.attach()

        binding.categoryTabViewpager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            var currentState = 0
            var currentPos = 0

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if(currentState == ViewPager2.SCROLL_STATE_DRAGGING && currentPos == position){
                    if(currentPos == 0) binding.categoryTabViewpager.currentItem = 3
                    else if(currentPos == 3) binding.categoryTabViewpager.currentItem = 0
                }
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                currentPos = position
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                currentState = state
                super.onPageScrollStateChanged(state)
            }
        } )
        return binding.root
    }


}