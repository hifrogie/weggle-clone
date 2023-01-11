package com.puresoftware.bottomnavigationappbar.brands

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puresoftware.bottomnavigationappbar.R
import com.puresoftware.bottomnavigationappbar.databinding.BrandsFragmentBinding


// overlapRecyclerView https://kimyunseok.tistory.com/130
class BrandsFragment : Fragment() {

    lateinit var binding: BrandsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view: View = inflater.inflate(R.layout.brands_fragment, container, false)
        binding = BrandsFragmentBinding.inflate(inflater, container, false)

        setUpRecyclerView()

        return binding.root
    }

    private fun setUpRecyclerView() {
        var itemList = mutableListOf(

            RecyclerOutViewModel(
                "(주)동아오츠카",
                "https://www.tfmedia.co.kr/data/photos/20180206/art_1518167665291_023679.jpg",
                mutableListOf(
                    RecyclerInViewModel(
                        "https://file.pickydiet.co.kr/image/PIKI/PRODUCT/PRD001/20221011/e11f8455a533009eb142221d3fd33021_600_600.jpg",
                        "(주)동아오츠카",
                        "포카리스웨트",
                        "50%",
                        "2,500"
                    ),
                    RecyclerInViewModel(
                        "https://scontent-gmp1-1.xx.fbcdn.net/v/t1.6435-9/57410715_1522986887836272_8472824990050287616_n.jpg?stp=cp0_dst-jpg_e15_p320x320_q65&_nc_cat=102&ccb=1-7&_nc_sid=110474&_nc_ohc=SJ3W1Ctugp0AX-prAT3&_nc_ht=scontent-gmp1-1.xx&oh=00_AfBWZHAoFBl_wHufwgBg18HLDE49KikMpfrw3cuWGNvrLA&oe=63E63688",
                        "(주)동아오츠카",
                        "이온워터",
                        "25%",
                        "1,500"
                    ),
                    RecyclerInViewModel(
                        "https://st.kakaocdn.net/thumb/P750x750/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fshoppingstore%2Fproduct%2F20220712071655_f0d1d0536da24bed89a4eb65a7cc82e4.png",
                        "(주)동아오츠카",
                        "마신다",
                        "70%",
                        "350"
                    ),
                ),
            ),

            RecyclerOutViewModel(
                "농심",
                "https://thumb.mt.co.kr/06/2017/07/2017071314130890218_2.jpg/dims/optimize/",
                mutableListOf(
                    RecyclerInViewModel(
                        "https://sitem.ssgcdn.com/79/44/63/item/0000008634479_i2_550.jpg",
                        "농심",
                        "신라면 1BOX",
                        "50%",
                        "2,500"
                    ),
                    RecyclerInViewModel(
                        "https://static.megamart.com/product/image/1346/13464110/13464110_1_960.jpg",
                        "농심",
                        "새우깡",
                        "10%",
                        "1,500"
                    ),
                ),
            ),
        )
        binding.outRecyclerview.adapter = OutRecyclerViewAdapter(requireContext(), itemList)
        binding.outRecyclerview.layoutManager = LinearLayoutManager(requireContext())

    }
}