package com.videohaven.server.video.controller

import com.videohaven.server.video.service.VideoChunkData
import com.videohaven.server.video.service.VideoChunkParam
import com.videohaven.server.video.service.VideoStreamService
import org.springframework.http.CacheControl
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class VideoStreamController(
    private val videoStreamService: VideoStreamService
) {

    @GetMapping("/video/streaming/{videoId}/{chunkName}")
    fun downloadVideoChunk(
        @PathVariable videoId: String, @PathVariable chunkName: String
    ): ResponseEntity<ByteArray> {
        val param = VideoChunkParam(
            videoId = videoId,
            chunkName = chunkName
        )
        val res = videoStreamService.streamVideoChunk(param)
        return makeVideoChunkResponse(res)
    }

    private fun makeVideoChunkResponse(data: VideoChunkData): ResponseEntity<ByteArray> {
        val headers = HttpHeaders()
        headers.setCacheControl(CacheControl.noCache().headerValue)

        return ResponseEntity<ByteArray>(data.data, headers, HttpStatus.OK)
    }
}