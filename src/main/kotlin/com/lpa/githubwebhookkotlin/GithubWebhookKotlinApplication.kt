package com.lpa.githubwebhookkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GithubWebhookKotlinApplication

fun main(args: Array<String>) {
    runApplication<GithubWebhookKotlinApplication>(*args)
}
