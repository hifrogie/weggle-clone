package com.puresoftware.bottomnavigationappbar.brands

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.puresoftware.bottomnavigationappbar.R
import com.puresoftware.bottomnavigationappbar.databinding.HolderRecyclerviewOutBinding

class OutRecyclerViewAdapter(
    val context: Context,
    val itemList: MutableList<RecyclerOutViewModel>
) : RecyclerView.Adapter<OutRecyclerViewAdapter.Holder>() {

    // https://yunaaaas.tistory.com/57
    // Fragment에 호출하게 될 listener
    interface OnItemClickListener {
        fun onItemClick(view: View, item: RecyclerOutViewModel, pos: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    var seek = 0

    // TAG
    val TAG: String = OutRecyclerViewAdapter::class.java.simpleName

    // ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            HolderRecyclerviewOutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val item = itemList[position]

        if (item.contentType == "image") { // 이미지
            // video <> image 보여주는 switch
            holder.binding.vvBrandsFullVideo.visibility = View.GONE
            holder.binding.ivBrandsFullImage.visibility = View.VISIBLE

            // glide 사용
            Glide.with(context).load(item.main)
                .into(holder.binding.ivBrandsFullImage)

        } else { // 비디오
            // video <> image 보여주는 switch
            holder.binding.vvBrandsFullVideo.visibility = View.VISIBLE
            holder.binding.ivBrandsFullImage.visibility = View.GONE

            // video 사용
            var videoUri = Uri.parse(item.main)
            holder.binding.vvBrandsFullVideo.setVideoURI(videoUri)

            // Video가 재생될 수 있는 상황이면 1회로 인해서 발동됨.
            holder.binding.vvBrandsFullVideo.setOnPreparedListener(object :
                MediaPlayer.OnPreparedListener {
                override fun onPrepared(p0: MediaPlayer?) {
                    holder.binding.vvBrandsFullVideo.start()

                    // 테스트 결과 동영상 불러오는 속도가 느리기 때문에 1초정도 검은화면이 지속됨. 중지재생은 가능
//                    if (seek > 0) {
//
//                        if (p0 != null) {
//                            p0.seekTo(seek)
//                        }
//
////                        holder.binding.vvBrandsFullVideo.seekTo(seek)
////                        holder.binding.vvBrandsFullVideo.start()
//                    }
                }
            })

            // Video 재생이 종료하면 영상을 재생함.
            holder.binding.vvBrandsFullVideo.setOnCompletionListener(object :
                MediaPlayer.OnCompletionListener {
                override fun onCompletion(p0: MediaPlayer?) {
                    holder.binding.vvBrandsFullVideo.start()
                }
            })
        }
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class Holder(var binding: HolderRecyclerviewOutBinding) :

        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecyclerOutViewModel) {
            binding.model = item

            binding.innerRecyclerview.adapter = InRecyclerViewAdapter(context, item.innerList)
            binding.innerRecyclerview.layoutManager =
                GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)

            // clickListener로 position 받아오기
            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView, item, pos)

                    Log.i("asdf", "position은요!: ${pos}")
                }
            }

            // Object 객체를 Intent로 전달하기(직렬화인 Serializable)
            // https://ardor-dev.tistory.com/76
            binding.laybtnBrandsExtend.setOnClickListener {

                Log.i("asdf", "버튼의 extends는요")
                val intent: Intent = Intent(context, BrandsItemExtendActivity::class.java)
                var bundle = Bundle()
                bundle.putSerializable("data", itemList[pos])
                intent.apply {
                    this.putExtra("bundle", bundle)
                }
                context.startActivity(intent)
//                seek = binding.vvBrandsFullVideo.currentPosition
            }
        }
    }
}