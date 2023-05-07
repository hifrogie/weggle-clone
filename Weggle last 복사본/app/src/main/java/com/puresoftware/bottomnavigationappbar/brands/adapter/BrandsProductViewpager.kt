package com.puresoftware.bottomnavigationappbar.brands.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puresoftware.bottomnavigationappbar.Home.adapter.SoonGroupbuyAdapter
import com.puresoftware.bottomnavigationappbar.Home.data.BodyList
import com.puresoftware.bottomnavigationappbar.R
import com.puresoftware.bottomnavigationappbar.databinding.BrandIncludeBinding
import com.puresoftware.bottomnavigationappbar.databinding.HolderRecyclerviewOutBinding
import com.puresoftware.bottomnavigationappbar.databinding.MainItemViewpagerBinding
import com.puresoftware.bottomnavigationappbar.databinding.RecyclerBinding

class BrandsProductViewpager(private val list:ArrayList<BodyList>,private val context: Context):RecyclerView.Adapter<BrandsProductViewpager.brandsProductHolder>() {

    class brandsProductHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val recyclerView = itemView.findViewById<RecyclerView>(R.id.brand_inner_recyclerview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): brandsProductHolder {
        val binding = RecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return brandsProductHolder(binding.root)
    }

    override fun onBindViewHolder(holder: brandsProductHolder, position: Int) {
        holder.recyclerView.adapter = SoonGroupbuyAdapter(list,context)
        holder.recyclerView.layoutManager = GridLayoutManager(context,2)
        holder.recyclerView.isNestedScrollingEnabled = false
    }

    override fun getItemCount(): Int {
        return list.size
    }
}