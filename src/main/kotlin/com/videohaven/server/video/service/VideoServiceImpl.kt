package com.videohaven.server.video.service

import com.videohaven.server.video.model.Video
import com.videohaven.server.video.repository.VideoRepository
import org.springframework.stereotype.Service


@Service
class VideoServiceImpl(
    private val videoRepository: VideoRepository
): VideoService {

    override fun getAllSeriesVideos(videoSeriesId: Long): List<Video> {
        val videos = videoRepository.findByVideoSeries(videoSeriesId)
        return videos
    }
}