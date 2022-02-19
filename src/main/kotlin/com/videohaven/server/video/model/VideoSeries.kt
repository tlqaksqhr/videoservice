package com.videohaven.server.video.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
class VideoSeries(
    @Id
    @Column(name = "id")
    @GeneratedValue
    val id: Long,

    val title: String,

    @Column(columnDefinition="TEXT")
    val content: String
)