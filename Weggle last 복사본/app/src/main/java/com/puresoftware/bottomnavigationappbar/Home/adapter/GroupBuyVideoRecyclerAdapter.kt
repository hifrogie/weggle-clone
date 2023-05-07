package com.puresoftware.bottomnavigationappbar.Home.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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
import com.puresoftware.bottomnavigationappbar.Home.data.GroupBuyRecyclerData
import com.puresoftware.bottomnavigationappbar.R

class GroupBuyVideoRecyclerAdapter(private val list:ArrayList<GroupBuyRecyclerData>,val context: Context):RecyclerView.Adapter<GroupBuyVideoRecyclerAdapter.GroupViewHolder>() {
    private lateinit var exoPlayerView: PlayerView
    private lateinit var player: SimpleExoPlayer
    private var playWhenReady = true

    inner class GroupViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val video = itemView.findViewById<PlayerView>(R.id.recyclerVideo)
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
            exoPlayerView = holder.video
            initailizePlayer(list[position].resource.toString())

    }

    override fun getItemCount(): Int {
        return list.size
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