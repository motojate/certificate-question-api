package com.example.certificatequestionapi.question.presentation.dto

import com.example.certificatequestionapi.common.annotation.AllOpen
import com.example.certificatequestionapi.common.enum.QuestionChapter

@AllOpen
class CreateQuestionDto(
    val questionText: String,
    val questionChapter: QuestionChapter
)