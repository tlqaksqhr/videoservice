package com.videohaven.server.video.model

import javax.persistence.*

@Entity
class Video(
    @Id
    @Column(name = "id")
    @GeneratedValue
    val id: Long,

    val title: String,

    val videoUrlPostFix: String,

    val dateUploaded: String,

    @ManyToOne
    @JoinColumn(name = "video_series_id")
    val videoSeries: VideoSeries
) {

}