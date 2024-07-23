package com.example.certificatequestionapi.question.domain.model

import jakarta.persistence.*

@Entity
class Answer(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "question_id")
    val question: Question,

    @Column
    val answerText: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}