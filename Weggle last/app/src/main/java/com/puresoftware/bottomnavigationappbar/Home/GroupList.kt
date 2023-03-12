package com.puresoftware.bottomnavigationappbar.Home

import com.puresoftware.bottomnavigationappbar.Weggler.Model.Product

data class GroupList(
    val name:String,
    val productList:ArrayList<Product>,
    val createTime:String,
    val updateTime:String
)
