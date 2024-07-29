package com.example.certificatequestionapi.question.domain.repository

import com.example.certificatequestionapi.question.domain.model.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : JpaRepository<Question, Long>, CustomQuestionRepository