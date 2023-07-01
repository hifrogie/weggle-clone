package com.puresoftware.bottomnavigationappbar.Home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.puresoftware.bottomnavigationappbar.CenterWeggle.CenterWeggleFragment
import com.puresoftware.bottomnavigationappbar.Home.data.GroupBuyRecyclerData
import com.puresoftware.bottomnavigationappbar.MainActivity
import com.puresoftware.bottomnavigationappbar.R
import com.puresoftware.bottomnavigationappbar.databinding.NewReviewVideoItemBinding

class NewGroupVideoRecyclerAdapter(val context: Context,private val list:ArrayList<GroupBuyRecyclerData>):RecyclerView.Adapter<NewGroupVideoRecyclerAdapter.NewViewHolder>() {
    private lateinit var binding:NewReviewVideoItemBinding

    inner class NewViewHolder(binding: NewReviewVideoItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        binding = NewReviewVideoItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return NewViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        Glide.with(context)
            .load(list[position].profileFile)
            .into(binding.newGroupbuyProfileImage)

        Glide.with(context)
            .load(list[position].thumbnail)
            .into(binding.newGroupbuyThumbnail)

        binding.newGroupbuyNickname.text = list[position].id
        binding.newGroupbuyHeartNumber.text = list[position].likeCount.toString()
        binding.newGroupbuyChatText.text = list[position].commentCount.toString()
        binding.newGroupbuyTitle.text = list[position].title

        holder.itemView.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, CenterWeggleFragment(false,list))
                .addToBackStack(null)
                .commit()

        }
    }
}