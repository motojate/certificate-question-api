package com.example.certificatequestionapi.question.application

import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.domain.model.MultipleChoiceQuestion
import com.example.certificatequestionapi.question.domain.model.Question
import com.example.certificatequestionapi.question.domain.repository.QuestionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QuestionService(private val questionRepository : QuestionRepository) {

    fun getAllQuestions(type: QuestionType): List<Question> {
        val actual = questionRepository.findByType(type)
        return actual
    }

    @Transactional
    fun createMultipleChoiceQuestion(questionText: String): MultipleChoiceQuestion {
        val question = MultipleChoiceQuestion(questionText)
        return questionRepository.save(question)
    }
}