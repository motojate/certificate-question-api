package com.example.certificatequestionapi.question.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Question(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column
    val answer: String
) {
    constructor() : this(0, "")
}