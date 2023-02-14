package com.puresoftware.bottomnavigationappbar.brands

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.puresoftware.bottomnavigationappbar.R
import com.puresoftware.bottomnavigationappbar.databinding.ActivityBrandsItemExtendBinding

class BrandsItemExtendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityBrandsItemExtendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // fragment에서 data 가져오기
        val bundle = intent.getBundleExtra("bundle")
        val data = bundle?.getSerializable("data") as RecyclerOutViewModel
        Log.i("asdf", "out: ${data.main}")
        Log.i("asdf", "in ${data.innerList.size}")

        // adapter 재활용
        val adapter = InRecyclerViewAdapter(this, data.innerList)
        adapter.notifyDataSetChanged()
        binding.rvBrandsExtend.adapter = adapter
        binding.rvBrandsExtend.layoutManager = GridLayoutManager(this, 2)

        // text,Img나 Video 적용
        binding.tvBrandsExtendTitle.text = data.company

        if (data.contentType == "image") { // 이미지
            // video <> image 보여주는 switch
            binding.vvBrandsExtendVideo.visibility = View.GONE
            binding.vvBrandsExtendImage.visibility = View.VISIBLE

            // glide 사용
            Glide.with(this).load(data.main)
                .into(binding.vvBrandsExtendImage)

        } else { // 비디오
            // video <> image 보여주는 switch
            binding.vvBrandsExtendVideo.visibility = View.VISIBLE
            binding.vvBrandsExtendImage.visibility = View.GONE

            // video 사용
            var videoUri = Uri.parse(data.main)
            binding.vvBrandsExtendVideo.setVideoURI(videoUri)

            // Video가 재생될 수 있는 상황이면 1회로 인해서 발동됨.
            binding.vvBrandsExtendVideo.setOnPreparedListener(object :
                MediaPlayer.OnPreparedListener {
                override fun onPrepared(p0: MediaPlayer?) {
                    binding.vvBrandsExtendVideo.start()
                }
            })

            // Video 재생이 종료하면 영상을 재생함.
            binding.vvBrandsExtendVideo.setOnCompletionListener(object :
                MediaPlayer.OnCompletionListener {
                override fun onCompletion(p0: MediaPlayer?) {
                    binding.vvBrandsExtendVideo.start()
                }
            })
        }
    }

    override fun onBackPressed() {
        finish()
    }
}