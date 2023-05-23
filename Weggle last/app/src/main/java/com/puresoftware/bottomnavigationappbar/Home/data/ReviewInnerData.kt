package com.puresoftware.bottomnavigationappbar.Home.data

import com.puresoftware.bottomnavigationappbar.Weggler.Model.MultiCommunityData
import java.io.Serializable

data class ReviewInnerData(val reviewId:Int,
                            val productId:Int,
                            val userInfo:UserInfoData,
                            val thumbnail:String,
                            val resource:String,
                            val body:MultiCommunityData,
                            val likeCount:Int,
                            val commentCount:Int,
                            val createTime:String,
                            val updateTime:String): Serializable
