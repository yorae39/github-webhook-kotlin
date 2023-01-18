package com.lpa.githubwebhookkotlin.repository

import com.lpa.githubwebhookkotlin.model.Event
import org.springframework.data.mongodb.repository.MongoRepository

interface EventRepository : MongoRepository<Event, String>