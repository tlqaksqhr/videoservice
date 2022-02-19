package com.videohaven.server.video.controller

import com.videohaven.server.video.model.Video
import com.videohaven.server.video.service.VideoItem
import com.videohaven.server.video.service.VideoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/video/items")
class VideoController(
    private val videoService: VideoService
) {

    @GetMapping("/{seriesId}")
    fun getVideosBySeries(@PathVariable seriesId: Long): List<VideoItemResponse> {
        val videoItems = videoService.getAllSeriesVideos(seriesId)
        return mappingVideoResponse(videoItems)
    }

    private fun mappingVideoResponse(videoItems: List<VideoItem>): List<VideoItemResponse> {
        return videoItems.map {
            VideoItemResponse(
                id = it.id,
                title = it.title,
                videoUrl = it.videoUrl,
                dateUploaded = it.dateUploaded
            )
        }.toList()
    }
}