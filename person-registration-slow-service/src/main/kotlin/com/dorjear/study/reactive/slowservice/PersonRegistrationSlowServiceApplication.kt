package com.dorjear.study.reactive.slowservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PersonRegistrationSlowServiceApplication

fun main(args: Array<String>) {
    runApplication<PersonRegistrationSlowServiceApplication>(*args)
}
