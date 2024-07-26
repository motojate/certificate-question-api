package com.example.certificatequestionapi.question.presentation.dto.request

import com.example.certificatequestionapi.common.annotation.AllOpen
import com.example.certificatequestionapi.common.enum.QuestionChapter
import com.example.certificatequestionapi.common.enum.QuestionType

@AllOpen
sealed class CreateQuestionDto(
    val questionText: String,
    val questionChapter: QuestionChapter,
    val questionType: QuestionType
)