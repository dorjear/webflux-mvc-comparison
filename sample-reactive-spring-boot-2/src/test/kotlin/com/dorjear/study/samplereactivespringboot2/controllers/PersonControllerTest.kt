package com.dorjear.study.samplereactivespringboot2.controllers

import com.dorjear.study.samplereactivespringboot2.models.Person
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.test.test

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PersonControllerTest {
    @LocalServerPort
    var port: Int? = null

    lateinit var webClient: WebClient

    @BeforeEach
    fun setUp() {
        webClient = WebClient.create("http://localhost:$port")
    }

    @Test
    fun `should add a Person`() {
        val person = Person("firstName", "lastName")

        webClient.post().uri("/persons")
                .accept(APPLICATION_JSON_UTF8)
                .body(Mono.just(person), Person::class.java)
                .exchange()
                .map { it.statusCode() }
                .test()
                .expectNext(CREATED)
                .verifyComplete()
    }
}
