package com.lpa.githubwebhookkotlin.log

import org.apache.log4j.Logger
import kotlin.reflect.full.companionObject

private fun logger(forClass: Class<*>): Logger = Logger.getLogger(forClass)

private fun <T : Any> getClassForLogging(javaClass: Class<T>): Class<*> {
    return javaClass.enclosingClass?.takeIf {
        it.kotlin.companionObject?.java == javaClass
    } ?: javaClass
}

fun <T : Any> T.logger(): Logger = logger(
    getClassForLogging(javaClass)
)