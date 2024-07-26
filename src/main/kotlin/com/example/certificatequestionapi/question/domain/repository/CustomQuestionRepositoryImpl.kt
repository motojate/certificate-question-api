package com.example.certificatequestionapi.question.domain.repository

import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.domain.model.MultipleChoiceQuestion
import com.example.certificatequestionapi.question.domain.model.Question
import com.example.certificatequestionapi.question.domain.model.ShortAnswerQuestion
import com.example.certificatequestionapi.question.presentation.dto.response.QuestionDto
import com.example.certificatequestionapi.question.presentation.dto.response.ShortAnswerQuestionDto
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import jakarta.persistence.EntityManager
import org.springframework.transaction.annotation.Transactional
import kotlin.reflect.KClass

open class CustomQuestionRepositoryImpl(
    private val kotlinJdslJpqlExecutor: KotlinJdslJpqlExecutor, private val em: EntityManager
) : CustomQuestionRepository {
    override fun getQuestionsByType(type: QuestionType): List<QuestionDto> {

//        val entityClass = when (type) {
//            QuestionType.MULTIPLE_CHOICE -> MultipleChoiceQuestion
//            QuestionType.SHORT_ANSWER -> ShortAnswerQuestion
//        }
//
        val questions = kotlinJdslJpqlExecutor.findAll {
            select(
                new(
                    QuestionDto::class,
                    path(Question::id),
                    path(Question::questionText),
                    path(Question::questionChapter),
                    path(Question::questionType),
                )
            ).from(entity(Question::class))
        }.requireNoNulls()

//        return kotlinJdslJpqlExecutor.findAll {
//            val parent = entity(Question::class)
//            val query = selectNew<QuestionDto>(
//                parent(Question::id),
//                parent(Question::questionText),
//                parent(Question::questionChapter),
//                parent(Question::questionType),
//            ).from(parent)
//            query
//        }.requireNoNulls()
        return questions
    }

//    private fun <T> commonSelectQuestion(entityClass: KClass<T>) {
//        return
//    }

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