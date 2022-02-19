package com.videohaven.server.video.controller

import com.videohaven.server.video.model.VideoSeries
import com.videohaven.server.video.service.VideoSeriesService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/video/series")
class VideoSeriesController(
    private val videoSeriesService: VideoSeriesService
) {

    @GetMapping("/all")
    fun getAllSeries(): List<VideoSeriesResponse>? {
        val series = videoSeriesService.getAllVideoSeries()
        return mapSeriesResponse(series)
    }

    private fun mapSeriesResponse(series: List<VideoSeries>): List<VideoSeriesResponse> {
        return series.map {
            VideoSeriesResponse(
                id = it.id,
                title = it.title,
                content = it.content
            )
        }.toList()
    }
}