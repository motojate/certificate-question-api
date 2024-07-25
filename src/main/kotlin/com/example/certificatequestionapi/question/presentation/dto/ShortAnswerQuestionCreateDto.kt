package com.example.certificatequestionapi.question.presentation.dto

import com.example.certificatequestionapi.common.enum.QuestionChapter
import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.domain.model.Answer

class ShortAnswerQuestionCreateDto(
    override val questionText: String,
    override val questionChapter: QuestionChapter,
    val answers: List<String>
) : CreateQuestionDto(questionText, QuestionType.SHORT_ANSWER, questionChapter)