package com.videohaven.server.video.service

import com.videohaven.server.video.model.VideoSeries
import com.videohaven.server.video.repository.VideoSeriesRepository
import org.springframework.stereotype.Service


@Service
class VideoSeriesServiceImpl(
    private val videoSeriesRepository: VideoSeriesRepository
): VideoSeriesService {

    override fun getAllVideoSeries(): List<VideoSeries> {
        return videoSeriesRepository.findAll()
    }
}