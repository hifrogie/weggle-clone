package com.puresoftware.bottomnavigationappbar.Home.groupbuy

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.puresoftware.bottomnavigationappbar.Home.adapter.SoonGroupbuyAdapter
import com.puresoftware.bottomnavigationappbar.Home.data.BodyList
import com.puresoftware.bottomnavigationappbar.Home.manager.GroupManager
import com.puresoftware.bottomnavigationappbar.MainActivity
import com.puresoftware.bottomnavigationappbar.Server.MasterApplication
import com.puresoftware.bottomnavigationappbar.databinding.FragmentFoodBinding

class GroupbuyFragment(val key:String) : Fragment() {

    private lateinit var binding: FragmentFoodBinding
    private lateinit var mainActivity: MainActivity
    private lateinit var groupManager: GroupManager
    private lateinit var wegglerApp : MasterApplication

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
        wegglerApp = mainActivity.masterApp
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        groupManager = GroupManager(wegglerApp)

        groupManager.getGroup(key){
            val foodList = ArrayList<BodyList>()
            for(i in 0 until it.productList.size) {
                foodList.add(
                    BodyList(it.productList[i].subjectFiles,
                    it.productList[i].name,
                    it.productList[i].body.company,
                    it.productList[i].body.charge,
                    it.productList[i].body.discount,
                    it.productList[i].body.original,
                    it.productList[i].body.price,
                    it.productList[i].body.duration,
                    it.productList[i].body.benefit,
                    it.productList[i].contentFiles,
                    it.productList[i].productId)
                )
            }
            binding.foodRecycler.adapter = context?.let {
                SoonGroupbuyAdapter(foodList, it)
            }
            binding.foodRecycler.layoutManager = GridLayoutManager(context,2)
        }
    }
}