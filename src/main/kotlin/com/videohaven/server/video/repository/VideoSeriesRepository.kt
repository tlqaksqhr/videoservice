package com.videohaven.server.video.repository

import com.videohaven.server.video.model.VideoSeries
import org.springframework.data.jpa.repository.JpaRepository


interface VideoSeriesRepository: JpaRepository<VideoSeries, Long> {
}