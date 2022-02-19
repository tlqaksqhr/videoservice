package com.videohaven.server.video.service

import com.videohaven.server.video.model.Video
import com.videohaven.server.video.repository.VideoRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class VideoServiceImpl(
    @Value("video.urlprefix")
    private val videoUrlPrefix: String,
    private val videoRepository: VideoRepository
): VideoService {

    override fun getAllSeriesVideos(videoSeriesId: Long): List<VideoItem> {
        val videos = videoRepository.findByVideoSeries(videoSeriesId)
        return mappingVideoItem(videos)
    }

    private fun mappingVideoItem(videos: List<Video>): List<VideoItem> {
        return videos.map {
            VideoItem(
                id = it.id,
                title = it.title,
                videoUrl = "${videoUrlPrefix}/${it.videoUrlPostFix}",
                dateUploaded = it.dateUploaded
            )
        }.toList()
    }
}