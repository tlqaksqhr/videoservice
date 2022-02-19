package com.videohaven.server.video.service

interface VideoStreamService {
    fun streamVideoChunk(videoChunkParam: VideoChunkParam): VideoChunkData
}