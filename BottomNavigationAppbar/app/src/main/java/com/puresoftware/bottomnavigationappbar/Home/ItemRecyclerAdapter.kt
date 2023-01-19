package com.puresoftware.bottomnavigationappbar.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.puresoftware.bottomnavigationappbar.R
import com.puresoftware.bottomnavigationappbar.databinding.HomeProductItemBinding

class ItemRecyclerAdapter(val itemList :List<Item>) : RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val itemBinding : HomeProductItemBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(item : Item){
//            val title: String, val company: String, val price: Int, val discountRate: Int
            Glide.with(itemBinding.productIv.context)
                .load(item.productURL)
                .placeholder(R.drawable.item_placeholder)
                .into(itemBinding.productIv)

            itemBinding.productTv.text = item.product
            itemBinding.companyTv.text = item.company
            itemBinding.discountRateTv.text = "${item.discountRate}%"
            itemBinding.priceTv.text = item.price.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(HomeProductItemBinding.inflate(LayoutInflater.from((parent.context)), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // TaskList 에 등록된 순서대로 position 이 0 번부터 넘버링 됨
        val item = itemList[position]
        holder.bindItem(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}