package com.videohaven.server.video.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Paths


@Service
class VideoStreamServiceImpl(
    @Value("video.filepath")
    private val filePath: String
): VideoStreamService {

    override fun streamVideoChunk(videoChunkParam: VideoChunkParam): VideoChunkData {
        val path = Paths.get(filePath, videoChunkParam.videoId, videoChunkParam.chunkName)
        val videoBytes = Files.readAllBytes(path)
        return VideoChunkData(
            videoBytes
        )
    }

}