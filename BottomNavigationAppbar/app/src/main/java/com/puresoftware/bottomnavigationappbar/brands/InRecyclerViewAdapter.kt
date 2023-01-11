package com.puresoftware.bottomnavigationappbar.brands

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.puresoftware.bottomnavigationappbar.R
import com.puresoftware.bottomnavigationappbar.databinding.HolderRecyclerviewInBinding

class InRecyclerViewAdapter(context: Context, val itemList: MutableList<RecyclerInViewModel>) :
    RecyclerView.Adapter<InRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            HolderRecyclerviewInBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]

        val context = holder.itemView.context
        Log.i("asdf", item.image)
        holder.binding.ivBrandsItem.setImageResource(R.drawable.wegglecircle)
        Glide.with(context).load("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory&fname=https://k.kakaocdn.net/dn/EShJF/btquPLT192D/SRxSvXqcWjHRTju3kHcOQK/img.png")
            .into(holder.binding.ivBrandsItem)

        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class Holder(var binding: HolderRecyclerviewInBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecyclerInViewModel) {
            binding.model = item
        }
    }

}