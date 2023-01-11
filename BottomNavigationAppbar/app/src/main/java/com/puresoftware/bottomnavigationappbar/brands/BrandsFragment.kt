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
                "포유류", mutableListOf(
                    RecyclerInViewModel("🐶", "강아지", "10000", "10000", "10000"),
                    RecyclerInViewModel("🐱", "고양이", "10000", "10000", "10000"),
                    RecyclerInViewModel("🐳", "고래", "10000", "10000", "10000"),
                    RecyclerInViewModel("🦒", "사슴", "10000", "10000", "10000")
                )
            ),

            RecyclerOutViewModel(
                "조류", mutableListOf(
                    RecyclerInViewModel("🦅", "독수리", "10000", "10000", "10000"),
                    RecyclerInViewModel("🕊️", "비둘기", "10000", "10000", "10000"),
                    RecyclerInViewModel("🦉", "부엉이", "10000", "10000", "10000"),
                    RecyclerInViewModel("🐔", "닭", "10000", "10000", "10000")
                )
            ),

            RecyclerOutViewModel(
                "어류", mutableListOf(
                    RecyclerInViewModel("🐟", "홍어", "10000", "10000", "10000"),
                    RecyclerInViewModel("🐟", "광어", "10000", "10000", "10000"),
                    RecyclerInViewModel("🐟", "연어", "10000", "10000", "10000"),
                    RecyclerInViewModel("🐟", "우럭", "10000", "10000", "10000")
                )
            ),

            RecyclerOutViewModel(
                "파충류", mutableListOf(
                    RecyclerInViewModel("🐊", "악어", "10000", "10000", "10000"),
                    RecyclerInViewModel("🦎", "카멜레온", "10000", "10000", "10000"),
                    RecyclerInViewModel("🦎", "도마뱀", "10000", "10000", "10000"),
                    RecyclerInViewModel("🐍", "뱀", "10000", "10000", "10000")
                )
            ),

            RecyclerOutViewModel(
                "양서류", mutableListOf(
                    RecyclerInViewModel("🐸", "개구리", "10000", "10000", "10000"),
                    RecyclerInViewModel("🦎", "도룡뇽", "10000", "10000", "10000"),
                    RecyclerInViewModel("🐸", "두꺼비", "10000", "10000", "10000")
                )
            ),
        )
        binding.outRecyclerview.adapter = OutRecyclerViewAdapter(requireContext(), itemList)
        binding.outRecyclerview.layoutManager = LinearLayoutManager(requireContext())
    }
}