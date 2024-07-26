package com.example.certificatequestionapi.question.presentation.dto.response

import com.example.certificatequestionapi.common.enum.QuestionChapter
import com.example.certificatequestionapi.common.enum.QuestionType

class ShortAnswerQuestionDto(
    override val id: Long,
    override val questionText: String,
    override val questionType: QuestionType,
    override val questionChapter: QuestionChapter,
) : QuestionDto(id, questionText, questionType, questionChapter)