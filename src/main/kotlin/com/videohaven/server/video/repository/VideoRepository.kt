package com.videohaven.server.video.repository

import com.videohaven.server.video.model.Video
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface VideoRepository: JpaRepository<Video, Long> {

    @Query("SELECT v FROM Video as v WHERE v.videoSeries.id = :seriesId")
    fun findByVideoSeries(@Param("seriesId") seriesId: Long): List<Video>

}