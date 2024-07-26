package com.example.certificatequestionapi.question.presentation.dto.response

import com.example.certificatequestionapi.common.annotation.AllOpen
import com.example.certificatequestionapi.common.enum.QuestionChapter
import com.example.certificatequestionapi.common.enum.QuestionType

@AllOpen
data class QuestionDto(
    val id: Long,
    val questionText: String,
    val questionType: QuestionType,
    val questionChapter: QuestionChapter
) {
    constructor(id: Long, questionText: String, questionChapter: QuestionChapter, questionType: QuestionType) : this(id, questionText, questionType, questionChapter)
}