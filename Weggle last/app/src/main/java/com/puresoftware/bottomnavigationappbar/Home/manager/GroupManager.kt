package com.puresoftware.bottomnavigationappbar.Home.manager

import android.util.Log
import com.puresoftware.bottomnavigationappbar.Home.GroupList
import com.puresoftware.bottomnavigationappbar.Home.data.GroupBuyData
import com.puresoftware.bottomnavigationappbar.Home.data.PagenationList
import com.puresoftware.bottomnavigationappbar.Server.MasterApplication
import com.puresoftware.bottomnavigationappbar.Weggler.Model.Product
import com.puresoftware.bottomnavigationappbar.Weggler.Model.ProductList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GroupManager(private val wApp: MasterApplication) {

    fun getGroup(name:String, paramFunc: (ArrayList<GroupBuyData>) -> Unit){
        wApp.service.addGroupProduct(name)
            .enqueue(object : Callback<GroupList> {
                override fun onResponse(call: Call<GroupList>, response: Response<GroupList>) {
                    if (response.isSuccessful) {
//                            var arrayProduct = ArrayList<String>()
//                            arrayProduct.add(response.body()!!.productList[].subjectFiles.first())
                        paramFunc(response.body()!!.productList)
                        Log.d("히히히히", response.errorBody().toString())
                    } else {
//                        Toast.makeText(this,"광고를 가져오는데 실패하였습니다.",Toast.LENGTH_LONG).show()
                        Log.d("하하하ㅏㅎ", "하하하하")
                        Log.d("하하하하", response.errorBody().toString())
                    }
                }
                override fun onFailure(call: Call<GroupList>, t: Throwable) {
                    Log.d("온페일", "하하하하")
                }

            })
    }

    //카테고리 product pagenation
    fun getCategoryProduct(category:String,paramFunc:(ArrayList<GroupBuyData>)->Unit){
        wApp.service.getCategoryProduct(category,0,10,listOf("id,ASC"))
            .enqueue(object : Callback<PagenationList>{
                override fun onResponse(call: Call<PagenationList>, response: Response<PagenationList>) {
                    if (response.isSuccessful){
                        response.body()?.let { paramFunc(it.content) }
                    }else{
                        Log.d("에러",response.errorBody()!!.string())
                    }
                }

                override fun onFailure(call: Call<PagenationList>, t: Throwable) {
                    Log.d("실패",t.toString())
                }

            })
    }

}

