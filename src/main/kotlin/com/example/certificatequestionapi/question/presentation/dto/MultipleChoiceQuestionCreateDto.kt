package com.example.certificatequestionapi.question.presentation.dto

import com.example.certificatequestionapi.common.enum.QuestionChapter
import com.example.certificatequestionapi.common.enum.QuestionLabel
import com.example.certificatequestionapi.common.enum.QuestionType

class MultipleChoiceQuestionCreateDto(
    override val questionText: String,
    override val questionChapter: QuestionChapter,
    val options: List<CreateOptionDto>,
    val answer: QuestionLabel
) : CreateQuestionDto(questionText, QuestionType.MULTIPLE_CHOICE, questionChapter)