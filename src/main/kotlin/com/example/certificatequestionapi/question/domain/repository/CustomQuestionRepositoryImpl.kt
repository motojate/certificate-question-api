package com.example.certificatequestionapi.question.domain.repository

import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.domain.model.MultipleChoiceQuestion
import com.example.certificatequestionapi.question.domain.model.Question
import com.example.certificatequestionapi.question.domain.model.ShortAnswerQuestion
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import jakarta.persistence.EntityManager
import org.springframework.transaction.annotation.Transactional

open class CustomQuestionRepositoryImpl(
    private val kotlinJdslJpqlExecutor: KotlinJdslJpqlExecutor, private val em: EntityManager
) : CustomQuestionRepository {
    override fun getQuestionsByType(type: QuestionType): List<Question> {
        println("impl 타입" + type)

        val entityClass = when (type) {
            QuestionType.MULTIPLE_CHOICE -> MultipleChoiceQuestion::class
            QuestionType.SHORT_ANSWER -> ShortAnswerQuestion::class
        }

        println("h" + entityClass)

        return kotlinJdslJpqlExecutor.findAll {
            select(entity(entityClass)).from(entity(entityClass))
        }.requireNoNulls()
    }

    @Transactional
    override fun createQuestion(question: Question): Question {
        em.persist(question)

        when (question) {
            is MultipleChoiceQuestion -> {
                question.options.forEach { em.persist(it) }
            }

            is ShortAnswerQuestion -> {}
        }

        question.answers.forEach { em.persist(it) }
        return question
    }
}