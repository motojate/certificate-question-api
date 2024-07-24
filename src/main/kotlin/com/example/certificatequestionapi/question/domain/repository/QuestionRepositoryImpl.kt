package com.example.certificatequestionapi.question.domain.repository

import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.domain.model.MultipleChoiceQuestion
import com.example.certificatequestionapi.question.domain.model.Question
import com.example.certificatequestionapi.question.domain.model.ShortAnswerQuestion
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.stereotype.Repository

@Repository
class QuestionRepositoryImpl(private val kotlinJdslJpqlExecutor: KotlinJdslJpqlExecutor) : CustomQuestionRepository {
    override fun findByType(type: QuestionType): List<Question> {
        val entityClass = when (type) {
            QuestionType.MULTIPLE_CHOICE -> MultipleChoiceQuestion::class
            QuestionType.SHORT_ANSWER -> ShortAnswerQuestion::class
        }
        return kotlinJdslJpqlExecutor.findAll {
            select(entity(entityClass)).from(entity(entityClass))
        }.requireNoNulls()
    }
}