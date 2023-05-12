package com.puresoftware.bottomnavigationappbar.Home.data

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive

data class GroupBuyRecyclerData(val id: JsonPrimitive?,
                                val profileFile:JsonPrimitive?,
                                val thumbnail: JsonPrimitive?,
                                val resource:JsonPrimitive?,
                                val likeCount:JsonPrimitive?,
                                val commentCount:JsonPrimitive?,
                                val updateTime:JsonPrimitive?,
                                val title:String?)
