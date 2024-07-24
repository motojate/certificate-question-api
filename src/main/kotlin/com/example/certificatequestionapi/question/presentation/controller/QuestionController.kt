package com.example.certificatequestionapi.question.presentation.controller

import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.application.QuestionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/questions")
class QuestionController(private val questionService: QuestionService) {

    @GetMapping
    fun getAllQuestions() = questionService.getAllQuestions(QuestionType.MULTIPLE_CHOICE);
}