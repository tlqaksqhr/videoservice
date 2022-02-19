package com.videohaven.server.video.controller

data class VideoItemResponse(
    val id: Long,
    val title: String,
    val videoUrl: String,
    val dateUploaded: String,
)
