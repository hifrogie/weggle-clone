package com.puresoftware.bottomnavigationappbar.Home.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.puresoftware.bottomnavigationappbar.Home.adapter.NewGroupVideoRecyclerAdapter
import com.puresoftware.bottomnavigationappbar.Home.data.GroupBuyRecyclerData
import com.puresoftware.bottomnavigationappbar.databinding.RecyclerBinding

class NewReviewVideoFragment(private val list:ArrayList<GroupBuyRecyclerData>):Fragment() {
    private lateinit var binding:RecyclerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RecyclerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.brandInnerRecyclerview.adapter = context?.let { NewGroupVideoRecyclerAdapter(it,list) }
        binding.brandInnerRecyclerview.layoutManager = GridLayoutManager(context,2)
    }
}