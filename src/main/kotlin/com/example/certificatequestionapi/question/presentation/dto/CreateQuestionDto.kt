package com.example.certificatequestionapi.question.presentation.dto

import com.example.certificatequestionapi.common.annotation.AllOpen
import com.example.certificatequestionapi.common.enum.QuestionChapter
import com.example.certificatequestionapi.common.enum.QuestionType

@AllOpen
class CreateQuestionDto(
    val questionText: String,
    val questionType: QuestionType,
    val questionChapter: QuestionChapter
)