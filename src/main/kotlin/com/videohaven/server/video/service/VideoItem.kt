package com.videohaven.server.video.service

data class VideoItem(
    val id: Long,
    val title: String,
    val videoUrl: String,
    val dateUploaded: String,
)
