package com.lpa.githubwebhookkotlin.controller

import com.lpa.githubwebhookkotlin.model.Event
import com.lpa.githubwebhookkotlin.service.EventService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
@RestController
class EventController(
    val eventService: EventService
) {
    @GetMapping
    fun getAllEvents() : List<Event> = eventService.findAll()

    @GetMapping("{id}")
    fun getEvent(@PathVariable id: String) = eventService.findById(id)

    @PostMapping
    fun postEvents(@RequestBody request: String) : ResponseEntity<String> {
        return ResponseEntity.ok(eventService.postEvents(request))
    }
}