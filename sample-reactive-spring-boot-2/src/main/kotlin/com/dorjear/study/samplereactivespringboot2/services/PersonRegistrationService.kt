package com.dorjear.study.samplereactivespringboot2.services

import com.dorjear.study.samplereactivespringboot2.models.Person
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders.ACCEPT
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.MediaType.*
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class PersonRegistrationService(@Value("\${registration.service}") private val registrationServiceBaseUrl: String) {

    private val webClient = WebClient.builder().baseUrl(registrationServiceBaseUrl).build()

    fun addPerson(person: Person): Mono<Person> {
        return webClient.post()
                .uri("/register")
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .header(ACCEPT, APPLICATION_JSON_VALUE)
                .body(fromValue(person))
                .exchangeToMono { it.bodyToMono(Person::class.java) }
    }
}
