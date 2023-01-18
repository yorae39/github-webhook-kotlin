package com.lpa.githubwebhookkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class GithubWebhookKotlinApplication

fun main(args: Array<String>) {
    runApplication<GithubWebhookKotlinApplication>(*args)
}
