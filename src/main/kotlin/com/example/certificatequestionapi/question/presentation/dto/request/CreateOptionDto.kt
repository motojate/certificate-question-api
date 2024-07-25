package com.example.certificatequestionapi.question.presentation.dto.request

import com.example.certificatequestionapi.common.enum.QuestionLabel

class CreateOptionDto (
    val optionText: String,
    val label: QuestionLabel
)