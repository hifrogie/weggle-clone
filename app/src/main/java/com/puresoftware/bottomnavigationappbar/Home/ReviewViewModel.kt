package com.puresoftware.bottomnavigationappbar.Home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puresoftware.bottomnavigationappbar.Home.data.GroupBuyRecyclerData
import com.puresoftware.bottomnavigationappbar.Home.manager.GroupManager
import com.puresoftware.bottomnavigationappbar.MainActivity
import com.puresoftware.bottomnavigationappbar.Server.MasterApplication

class ReviewViewModel(private val context: Context): ViewModel() {
    private lateinit var mainActivity: MainActivity
    private lateinit var wegglerApp: MasterApplication
    private lateinit var groupManager: GroupManager


    private val _reviewData: MutableLiveData<ArrayList<GroupBuyRecyclerData>> by lazy {
        MutableLiveData<ArrayList<GroupBuyRecyclerData>>().also {
            loadReviewVideo()
        }
    }
    val reviewData: LiveData<ArrayList<GroupBuyRecyclerData>> = _reviewData

    fun getReviewData(data: ArrayList<GroupBuyRecyclerData>) {
        _reviewData.value = data
    }
    fun loadReviewVideo():ArrayList<GroupBuyRecyclerData> {

        mainActivity = context as MainActivity
        wegglerApp = mainActivity.masterApp
        groupManager = GroupManager(wegglerApp)

        val groupBuyVideoList = arrayListOf<GroupBuyRecyclerData>()
        groupManager.getReview {
            for (i in it) {
                if (i.resource?.contains("m3u8") == true) {
                    groupBuyVideoList.add(
                        GroupBuyRecyclerData(
                            i.userInfo?.id,
                            i.userInfo?.profileFile,
                            i.thumbnail,
                            i.resource,
                            i.likeCount,
                            i.commentCount,
                            i.updateTime,
                            i.productId,
                            i.title
                        )
                    )
                }
            }
        }
    return groupBuyVideoList
    }
}