package com.example.certificatequestionapi.question.presentation.dto.response

import com.example.certificatequestionapi.common.enum.QuestionChapter
import com.example.certificatequestionapi.common.enum.QuestionType

class MultipleChoiceQuestionDto(
    override val id: Long,
    override val questionText: String,
    override val questionType: QuestionType,
    override val questionChapter: QuestionChapter,
    val options: List<OptionDto>
) : QuestionDto(id, questionText, questionType, questionChapter)