package com.example.certificatequestionapi.question.presentation.dto.request

import com.example.certificatequestionapi.common.enum.QuestionChapter
import com.example.certificatequestionapi.common.enum.QuestionLabel

class MultipleChoiceQuestionCreateDto(
    override val questionText: String,
    override val questionChapter: QuestionChapter,
    val options: List<CreateOptionDto>,
    val answer: QuestionLabel
) : CreateQuestionDto(questionText, questionChapter)