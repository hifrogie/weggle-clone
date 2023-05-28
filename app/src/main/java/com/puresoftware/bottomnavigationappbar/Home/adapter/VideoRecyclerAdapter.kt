package com.puresoftware.bottomnavigationappbar.Home.adapter

import android.app.Activity
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
import com.google.gson.JsonObject
import com.puresoftware.bottomnavigationappbar.Home.data.GroupBuyRecyclerData
import com.puresoftware.bottomnavigationappbar.R
import com.puresoftware.bottomnavigationappbar.databinding.CenterWeggleCardviewBinding
import com.puresoftware.bottomnavigationappbar.databinding.CenterWeggleFragmentBinding
import com.puresoftware.bottomnavigationappbar.databinding.ItemMiniProductTypeImageBinding
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class VideoRecyclerAdapter(val activity: Activity, private val arrayList: ArrayList<GroupBuyRecyclerData>, private val context: Context) : RecyclerView.Adapter<VideoRecyclerAdapter.VideoViewHolder>() {

    private lateinit var binding: CenterWeggleCardviewBinding
    private lateinit var exoPlayerView: PlayerView
    private lateinit var player: SimpleExoPlayer
    private var playWhenReady = true

    inner class VideoViewHolder(binding: CenterWeggleCardviewBinding):RecyclerView.ViewHolder(binding.root) {
        val profileImage = itemView.findViewById<CircleImageView>(R.id.video_my_image)
        val profileName = itemView.findViewById<TextView>(R.id.video_my_nickname)
        val videoTitle = itemView.findViewById<TextView>(R.id.video_title)
        val videoPercentage = itemView.findViewById<TextView>(R.id.video_percentage)
        val videoPrice = itemView.findViewById<TextView>(R.id.video_price)
        val videoCategory = itemView.findViewById<TextView>(R.id.video_product_category)
        val videoTime = itemView.findViewById<TextView>(R.id.video_time)
        val videoImage = itemView.findViewById<ImageView>(R.id.video_image)

        fun bind() {

            binding.videoMyNickname.text = arrayList[absoluteAdapterPosition].id
            binding.videoFavoriteNumber.text = arrayList[absoluteAdapterPosition].likeCount.toString()
            binding.videoTime.text = arrayList[absoluteAdapterPosition].updateTime

            exoPlayerView = binding.video
            arrayList[absoluteAdapterPosition].resource?.let { initailizePlayer(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        binding = CenterWeggleCardviewBinding.inflate(
            LayoutInflater.from(activity), parent, false
        )
        return VideoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind()
    }
    private fun initailizePlayer(url: String) {
        player = ExoPlayerFactory.newSimpleInstance(this.context)
        exoPlayerView.setPlayer(player)

        val mediaSource = buildMediaSource(Uri.parse((url)))
        player.prepare(mediaSource, true, false)
        player.setPlayWhenReady(playWhenReady)
    }

    private fun buildMediaSource(uri: Uri): MediaSource {
        val userAgent = Util.getUserAgent(this.context, "BottomNavigationAppbar")

        if (uri.lastPathSegment!!.contains("mp3") || uri.lastPathSegment!!.contains("mp4")) {
            return ExtractorMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
                .createMediaSource(uri)
        } else if (uri.lastPathSegment!!.contains("m3u8")) {
            return HlsMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
                .createMediaSource(uri)
        } else {
            return ExtractorMediaSource.Factory(DefaultDataSourceFactory(this.context, userAgent))
                .createMediaSource(uri)
        }
    }
}