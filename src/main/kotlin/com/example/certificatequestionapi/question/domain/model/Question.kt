package com.example.certificatequestionapi.question.domain.model

import com.example.certificatequestionapi.common.annotation.AllOpen
import com.example.certificatequestionapi.common.enum.QuestionType
import jakarta.persistence.*

@AllOpen
@Entity
@Table(name = "QUESTIONS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "question_type")
abstract class Question(
    @Column(name = "question_text")
    val questionText: String,

    val type: QuestionType
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0;

    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], orphanRemoval = true)
    val answers: MutableList<Answer> = mutableListOf();
}