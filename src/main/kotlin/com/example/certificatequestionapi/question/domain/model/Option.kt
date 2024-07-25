package com.example.certificatequestionapi.question.domain.model

import com.example.certificatequestionapi.common.enum.QuestionLabel
import jakarta.persistence.*

@Entity
@Table(name = "OPTIONS")
class Option(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    val question: MultipleChoiceQuestion,

    @Column(name = "option_text", nullable = false)
    val optionText: String,

    @Column(name = "label", nullable = false)
    val label: QuestionLabel
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}