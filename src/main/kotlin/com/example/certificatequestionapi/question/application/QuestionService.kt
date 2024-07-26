package com.example.certificatequestionapi.question.application

import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.domain.model.MultipleChoiceQuestion
import com.example.certificatequestionapi.question.domain.model.Question
import com.example.certificatequestionapi.question.domain.model.ShortAnswerQuestion
import com.example.certificatequestionapi.question.domain.repository.QuestionRepository
import com.example.certificatequestionapi.question.presentation.dto.request.MultipleChoiceQuestionCreateDto
import com.example.certificatequestionapi.question.presentation.dto.request.ShortAnswerQuestionCreateDto
import com.example.certificatequestionapi.question.presentation.dto.response.QuestionDto
import org.springframework.stereotype.Service

@Service
class QuestionService(private val questionRepository : QuestionRepository) {

    fun getAllQuestions(type: QuestionType): List<QuestionDto> {
        val questions = questionRepository.getQuestionsByType(type)
        return questions;
    }

    fun createShortAnswerQuestion(dto: ShortAnswerQuestionCreateDto): Question {
        val question = ShortAnswerQuestion(dto.questionText, dto.questionChapter)
        dto.answers.forEach { question.addAnswer(it) }
        return questionRepository.createQuestion(question);
    }

    fun createMultipleChoiceQuestion(dto: MultipleChoiceQuestionCreateDto): Question {
        val question = MultipleChoiceQuestion(dto.questionText, dto.questionChapter)
        dto.options.forEach { question.addOption(it.optionText, it.label) }
        dto.answer.let { question.addAnswer(it.name) }

        return questionRepository.createQuestion(question)
    }
}