package com.example.certificatequestionapi.question.presentation.controller

import com.example.certificatequestionapi.common.enum.QuestionType
import com.example.certificatequestionapi.question.application.QuestionService
import com.example.certificatequestionapi.question.domain.model.Question
import com.example.certificatequestionapi.question.presentation.dto.request.MultipleChoiceQuestionCreateDto
import com.example.certificatequestionapi.question.presentation.dto.request.ShortAnswerQuestionCreateDto
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
    fun getAllQuestions(@RequestParam("questionType") questionType: QuestionType): ResponseEntity<List<Question>> {
        val questions = questionService.getAllQuestions(questionType);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/multiple-choice")
    fun createMultipleChoiceQuestion(@RequestBody request: MultipleChoiceQuestionCreateDto): ResponseEntity<Question> {
        val question = questionService.createMultipleChoiceQuestion(request)
        return ResponseEntity.ok(question);
    }

    @PostMapping("/short-answer")
    fun createShortAnswerQuestion(@RequestBody request: ShortAnswerQuestionCreateDto): ResponseEntity<Question> {
        val question = questionService.createShortAnswerQuestion(request)
        return ResponseEntity.ok(question);
    }

}