package com.example.certificatequestionapi.question.domain.repository

import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.domain.model.Question

interface CustomQuestionRepository {
    fun findByType(type: QuestionType) : List<Question>
}