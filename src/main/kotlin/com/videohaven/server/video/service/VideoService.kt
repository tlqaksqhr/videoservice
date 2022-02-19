package com.videohaven.server.video.service

import com.videohaven.server.video.model.Video


interface VideoService {
    fun getAllSeriesVideos(videoSeriesId: Long): List<Video>
}