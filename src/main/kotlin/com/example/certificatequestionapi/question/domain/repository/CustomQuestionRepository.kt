package com.example.certificatequestionapi.question.domain.repository

import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.domain.model.Question

interface CustomQuestionRepository {
    fun getQuestionsByType(type: QuestionType): List<Question>
    fun createQuestion(question: Question): Question
}