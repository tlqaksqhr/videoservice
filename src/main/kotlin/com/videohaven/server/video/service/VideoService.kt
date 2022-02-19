package com.videohaven.server.video.service

interface VideoService {
    fun getAllSeriesVideos(videoSeriesId: Long): List<VideoItem>
}