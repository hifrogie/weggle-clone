package com.puresoftware.bottomnavigationappbar.Home.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.puresoftware.bottomnavigationappbar.Home.GroupList
import com.puresoftware.bottomnavigationappbar.Home.category.CategoryFragment
import com.puresoftware.bottomnavigationappbar.Home.data.BodyList
import com.puresoftware.bottomnavigationappbar.Home.data.GroupBuyData
import com.puresoftware.bottomnavigationappbar.Home.detail.ProductDetailFragment
import com.puresoftware.bottomnavigationappbar.MainActivity
import com.puresoftware.bottomnavigationappbar.R
import com.puresoftware.bottomnavigationappbar.Weggler.Model.Product

class GroupBuyRecyclerAdapter(private val list:ArrayList<BodyList>,val context: Context): RecyclerView.Adapter<GroupBuyRecyclerAdapter.GroupBuyRecyclerHolder>() {
    inner class GroupBuyRecyclerHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val soonImage = itemView.findViewById<ImageView>(R.id.include_image)
        val soonOfficeText = itemView.findViewById<TextView>(R.id.include_office_textview)
        val soonProductText = itemView.findViewById<TextView>(R.id.include_product_textview)
        val soonPercentageText = itemView.findViewById<TextView>(R.id.include_percentage)
        val soonPriceText = itemView.findViewById<TextView>(R.id.include_price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupBuyRecyclerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.group_buy_recycler_item,parent,false)
        return GroupBuyRecyclerHolder(view)
    }

    override fun onBindViewHolder(holder: GroupBuyRecyclerHolder, position: Int) {
        Glide.with(context)
            .load(list[position].image.first())
            .into(holder.soonImage)

        holder.soonOfficeText.text = list[position].company
        holder.soonProductText.text = list[position].name
        holder.soonPercentageText.text = list[position].discount.toString()
        holder.soonPriceText.text = list[position].price.toString()

        holder.itemView.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, ProductDetailFragment(list,position))
                .addToBackStack(null)
                .commit()

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}