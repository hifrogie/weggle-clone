package com.puresoftware.bottomnavigationappbar.Home.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.google.android.material.divider.MaterialDivider
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.JsonPrimitive
import com.puresoftware.bottomnavigationappbar.Home.data.GroupBuyRecyclerData
import com.puresoftware.bottomnavigationappbar.Home.manager.GroupManager
import com.puresoftware.bottomnavigationappbar.MainActivity
import com.puresoftware.bottomnavigationappbar.R
import com.puresoftware.bottomnavigationappbar.Server.MasterApplication
import org.json.JSONObject

class GroupBuyVideoRecyclerAdapter(private val jsonObject: JsonObject, val context: Context):RecyclerView.Adapter<GroupBuyVideoRecyclerAdapter.GroupViewHolder>() {
    private lateinit var exoPlayerView: PlayerView
    private lateinit var player: SimpleExoPlayer
    private var playWhenReady = true
    private lateinit var wegglerApp: MasterApplication
    private lateinit var groupManager: GroupManager
    val jsonArray = jsonObject.getAsJsonArray("content")

    inner class GroupViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.recyclerImageview)
        val title = itemView.findViewById<TextView>(R.id.groupTitle)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): GroupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_recycler_item,parent,false)
        return GroupViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: GroupBuyVideoRecyclerAdapter.GroupViewHolder,
        position: Int,
    ) {
        val mainActivity = context as MainActivity
        wegglerApp = mainActivity.masterApp
        groupManager = GroupManager(wegglerApp)

        val content = jsonArray.get(position) as JsonObject
        val thumbnail = content.get("thumbnail")
        if (thumbnail != null) {
            Glide.with(context)
                .load(thumbnail.toString().replace("\"",""))
                .into(holder.image)

            groupManager.getProduct(content.get("productId").asInt) {
                         holder.title.text = it.get("name").toString()
                     }
        }


    }

    override fun getItemCount(): Int {
        return jsonObject.getAsJsonArray("content").size()
    }
    private fun initailizePlayer(url:String){
        player = ExoPlayerFactory.newSimpleInstance(this.context)
        exoPlayerView.setPlayer(player)

        val mediaSource = buildMediaSource(Uri.parse((url)))
        player.prepare(mediaSource,true,false)
        player.setPlayWhenReady(playWhenReady)
    }
    private fun buildMediaSource(uri: Uri): MediaSource {
        val userAgent = Util.getUserAgent(this.context,"BottomNavigationAppbar")

        if(uri.lastPathSegment!!.contains("mp3")||uri.lastPathSegment!!.contains("mp4")){
            return ExtractorMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent)).createMediaSource(uri)
        } else if (uri.lastPathSegment!!.contains("m3u8")){
            return HlsMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent)).createMediaSource(uri)
        } else{
            return ExtractorMediaSource.Factory(DefaultDataSourceFactory(this.context,userAgent)).createMediaSource(uri)
        }
    }
}