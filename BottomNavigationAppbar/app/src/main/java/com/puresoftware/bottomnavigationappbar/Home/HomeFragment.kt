package com.puresoftware.bottomnavigationappbar.Home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.puresoftware.bottomnavigationappbar.databinding.HomeFragmentBinding
import com.smarteist.autoimageslider.SliderView

class HomeFragment : Fragment() {

    lateinit var binding : HomeFragmentBinding
    lateinit var imageUrl: ArrayList<String>
    lateinit var sliderView: SliderView
    lateinit var sliderAdapter: SliderAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
//        이미지 슬라이더
        sliderView = binding.slider

        imageUrl = ArrayList()
        // on below line we are adding data to our image url array list.
        imageUrl =
            (imageUrl + "https://newsimg.sedaily.com/2022/02/03/261ZXAMLN9_1.jpg") as ArrayList<String>
        imageUrl =
            (imageUrl + "http://www.happypet.co.kr/news/photo/202201/0004565570_5186931_article.jpg") as ArrayList<String>
        imageUrl =
            (imageUrl + "http://m.segyebiz.com/content/image/2021/10/27/20211027515262.jpg") as ArrayList<String>

        sliderAdapter = SliderAdapter(imageUrl)
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 4

        sliderView.isAutoCycle = true

        sliderView.startAutoCycle()
        Log.i("Song", "HomeFragment start")

//        리사이클러뷰
        val adapter = ItemRecyclerAdapter(ItemList.itemList)
        binding?.recentProductRv?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recentProductRv?.adapter = adapter

        return binding.root
    }

}