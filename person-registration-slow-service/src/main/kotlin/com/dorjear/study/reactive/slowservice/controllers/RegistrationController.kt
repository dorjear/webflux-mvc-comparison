package com.dorjear.study.reactive.slowservice.controllers

import com.dorjear.study.reactive.slowservice.models.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.UUID

@RestController
class RegistrationController {

    @PostMapping("/register")
    @ResponseStatus(CREATED)
    fun register(@RequestBody person: Mono<Person>): Mono<Person> {
        return person.delayElement(Duration.ofMillis(200)) // Mimic blocking nature
                .map {
                    it.copy(id = UUID.randomUUID())
                }

    }

}
