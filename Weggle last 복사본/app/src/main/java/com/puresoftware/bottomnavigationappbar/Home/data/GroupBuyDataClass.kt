package com.puresoftware.bottomnavigationappbar.Home.data

data class GroupBuyDataClass(val name:String,
                            val productList:ArrayList<GroupBuyData>,
                            val body:GroupBuyBody,
                             val thumbnail:String="",
                             val resource:String="",
                             val createTime:String,
                             val updateTime:String)
