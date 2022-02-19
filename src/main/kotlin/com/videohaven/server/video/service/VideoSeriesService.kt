package com.videohaven.server.video.service

import com.videohaven.server.video.model.VideoSeries

interface VideoSeriesService {

    fun getAllVideoSeries(): List<VideoSeries>
}