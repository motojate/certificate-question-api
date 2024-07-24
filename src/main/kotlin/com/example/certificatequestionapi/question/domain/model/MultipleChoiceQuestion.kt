package com.example.certificatequestionapi.question.domain.model

import com.example.certificatequestionapi.common.enum.QuestionType
import jakarta.persistence.CascadeType
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany

@Entity
@DiscriminatorValue("MULTIPLE_CHOICE")
class MultipleChoiceQuestion(
    questionText: String,

    @OneToMany(
        mappedBy = "question",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    ) val options: MutableList<Option> = mutableListOf()
) : Question(questionText, QuestionType.MULTIPLE_CHOICE)