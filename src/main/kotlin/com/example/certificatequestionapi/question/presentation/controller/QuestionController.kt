package com.example.certificatequestionapi.question.presentation.controller

import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.application.QuestionService
import com.example.certificatequestionapi.question.domain.model.Question
import com.example.certificatequestionapi.question.presentation.dto.request.CreateQuestionDto
import com.example.certificatequestionapi.question.presentation.dto.request.MultipleChoiceQuestionCreateDto
import com.example.certificatequestionapi.question.presentation.dto.request.ShortAnswerQuestionCreateDto
import com.example.certificatequestionapi.question.presentation.dto.response.QuestionDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/questions")
class QuestionController(private val questionService: QuestionService) {

    @GetMapping
    fun getAllQuestions(@RequestParam("questionType") questionType: QuestionType): ResponseEntity<List<QuestionDto>> {
        val questions = questionService.getAllQuestions(questionType);
        return ResponseEntity.ok(questions);
    }

    @PostMapping
    fun createMultipleChoiceQuestion(@RequestBody request: CreateQuestionDto): ResponseEntity<Question> {
        val question = when (request) {
            is ShortAnswerQuestionCreateDto -> questionService.createShortAnswerQuestion(request)
            is MultipleChoiceQuestionCreateDto -> questionService.createMultipleChoiceQuestion(request)
        }

        return ResponseEntity.ok(question);
    }



}