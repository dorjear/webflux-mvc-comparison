package com.dorjear.study.samplespringboot2.models

import java.util.UUID

data class Person(val firstName: String, val lastName: String, val id:UUID? = null)
