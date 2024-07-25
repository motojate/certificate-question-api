package com.example.certificatequestionapi.question.presentation.dto

import com.example.certificatequestionapi.common.enum.QuestionChapter

class ShortAnswerQuestionCreateDto(
    override val questionText: String,
    override val questionChapter: QuestionChapter,
    val answers: List<String>
) : CreateQuestionDto(questionText, questionChapter)