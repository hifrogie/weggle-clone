package com.puresoftware.bottomnavigationappbar.Home.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puresoftware.bottomnavigationappbar.R
import com.puresoftware.bottomnavigationappbar.databinding.FragmentDetailReviewBinding
import com.puresoftware.bottomnavigationappbar.databinding.FragmentFashionBinding


class DetailReviewFragment : Fragment() {

    private lateinit var binding:FragmentDetailReviewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

}