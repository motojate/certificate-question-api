package com.example.certificatequestionapi.question.domain.repository

import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.domain.model.Question
import com.example.certificatequestionapi.question.presentation.dto.response.QuestionDto

interface CustomQuestionRepository {
    fun getQuestionsByType(type: QuestionType): List<QuestionDto>
    fun createQuestion(question: Question): Question
}