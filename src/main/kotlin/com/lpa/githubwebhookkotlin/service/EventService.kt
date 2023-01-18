package com.lpa.githubwebhookkotlin.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.lpa.githubwebhookkotlin.log.logger
import com.lpa.githubwebhookkotlin.model.Event
import com.lpa.githubwebhookkotlin.repository.EventRepository
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class EventService(
    val eventRepository: EventRepository,
    val rabbitTemplate: RabbitTemplate,
    val objectMapper: ObjectMapper,
    @Value("\${queue.name")
    val queueName: String
) {

    fun findAll() = eventRepository.findAll()

    fun findById(id: String) = eventRepository.findById(id)

    fun postEvents(request: String) : String {
        val event = eventRepository.save(Event(message = request))
        logger().info("Persisted the github event ${event.id} in db")
        rabbitTemplate.convertAndSend(queueName, objectMapper.writeValueAsString(event))
        logger().info("Published the github event ${event.id} to rabbitmq")
        return formatMessage("Persisted the github event ${event.id} in db", "Published the github event ${event.id} to rabbitmq")

    }

    private fun formatMessage(valueOne: String, valueTwo: String) : String {
        val builder = StringBuilder()
        builder.append(valueOne).append("\n").append(valueTwo)
        return builder.toString()
    }
}