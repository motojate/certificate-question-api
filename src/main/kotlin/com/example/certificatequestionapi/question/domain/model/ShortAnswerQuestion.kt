package com.example.certificatequestionapi.question.domain.model

import com.example.certificatequestionapi.common.enum.QuestionType
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("SHORT_ANSWER")
class ShortAnswerQuestion(questionText: String) : Question(questionText, QuestionType.SHORT_ANSWER)