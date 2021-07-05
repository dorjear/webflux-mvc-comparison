package com.dorjear.study.reactive.slowservice.controllers

import com.dorjear.study.reactive.slowservice.models.Person
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters

@WebFluxTest(controllers = [RegistrationController::class])
class RegistrationControllerTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun `should register a person`() {
        val person = Person("firstName", "secondName")

        webTestClient.post().uri("/register")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .body(BodyInserters.fromValue(person))
                .exchange()
                .expectStatus().isCreated
                .expectBody()
                .jsonPath("firstName").isEqualTo(person.firstName)
                .jsonPath("lastName").isEqualTo(person.lastName)
                .jsonPath("id").isNotEmpty
    }
}
