package com.example.certificatequestionapi.user.domain.model

import com.example.certificatequestionapi.common.enum.QuestionType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class User(
    @Id @Column(name = "user_seq")
    val userSeq: String,

    @Column(name = "name")
    val name: String,
) {
    @Column(name = "level")
    val level: Int = 1

    @Column(name = "exp")
    val exp: Int = 0

    @Column(name = "select_question_type")
    val selectQuestionType: QuestionType = QuestionType.SHORT_ANSWER

    @Column(name = "select_question_count")
    val selectQuestionCount: Int = 20
}