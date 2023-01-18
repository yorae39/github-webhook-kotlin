package com.lpa.githubwebhookkotlin.model

import org.springframework.data.annotation.Id

data class Event(
    @Id
    var id: String? = null,
    val msg: String
)