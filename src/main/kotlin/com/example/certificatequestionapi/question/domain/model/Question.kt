package com.example.certificatequestionapi.question.domain.model

import jakarta.persistence.*

@Entity
class Question(
    @Column
    val question: String
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0;

    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], orphanRemoval = true)
    val answers: MutableList<Answer> = mutableListOf();
}